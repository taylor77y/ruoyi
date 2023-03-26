<template>
    <div class="app-container">
        <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="88px">
            <el-form-item label="产品名称" prop="name">
                <el-input v-model="queryParams.name" placeholder="请输入产品名称" clearable @keyup.enter.native="handleQuery" />
            </el-form-item>
            <el-form-item>
                <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
                <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
            </el-form-item>
        </el-form>

        <el-row :gutter="10" class="mb8">
            <el-col :span="1.5">
                <el-button type="primary" plain icon="el-icon-add" size="mini" @click="handleAdd"
                    v-hasPermi="['	system:fundProduct:add']">新增</el-button>
            </el-col>
            <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>

        <el-table v-loading="loading" :data="contractOrderList" @selection-change="handleSelectionChange">
            <el-table-column label="产品名称" prop="zhName" />
            <el-table-column label="产品名称(英文)" prop="enName" />
            <el-table-column label="图片" prop="fundImage">
                <template slot-scope="scope">
                    <el-image :src="scope.row.fundImage" style="width: 64px;height: 64px;"/>
                </template>
            </el-table-column>
            <el-table-column label="周期(天)" prop="periodDay" />
            <el-table-column label="日利率(%)(显示在APP端给客户看的)" prop="fundImage" width="240">
                <template slot-scope="{row}">
                    {{ row.dayRateFront }} -- {{ row.dayRateBehind }}
                </template>
            </el-table-column>
            <el-table-column label="今日利率(%)(实际结算收益时候的使用的)" prop="todayRate" width="260" />
            <el-table-column label="违约结算比例(%)" prop="defaultRatio" />
            <el-table-column label="投资金额区间(USDT)" prop="fundImage">
                <template slot-scope="{row}">
                    {{ row.investmentAmountFront }} -- {{ row.investmentAmountBehind }}
                </template>
            </el-table-column>
            <el-table-column label="状态" prop="enabled">
                <template slot-scope="scope">
                    <el-tag>{{ ['停用', '启用'][scope.row.enabled] }}</el-tag>
                </template>
            </el-table-column>
            <el-table-column label="操作" fixed="right" class-name="small-padding fixed-width">
                <template slot-scope="scope">
                    <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
                        v-hasPermi="['system:fundProduct:edit']">修改</el-button>
                    <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
                        v-hasPermi="['system:fundProduct:remove']">删除</el-button>
                </template>
            </el-table-column>
        </el-table>

        <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNum" :limit.sync="queryParams.pageSize"
            @pagination="getList" />

        <el-dialog :title="title" :visible.sync="open" width="900px" append-to-body>
            <el-form ref="form" :model="form" :rules="rules" label-width="180px">
                <el-form-item label="产品名称(简体中文)" prop="zhName">
                    <el-input v-model="form.zhName" placeholder="请输入产品名称(简体中文)" />
                </el-form-item>
                <el-form-item label="产品名称(繁体中文)" prop="zhTwName">
                    <el-input v-model="form.zhTwName" placeholder="请输入产品名称(繁体中文)" />
                </el-form-item>
                <el-form-item label="产品名称(英文)" prop="enName">
                    <el-input v-model="form.enName" placeholder="请输入产品名称(英文)" />
                </el-form-item>
                <el-form-item label="产品名称(韩语)" prop="koName">
                    <el-input v-model="form.koName" placeholder="请输入产品名称(韩语)" />
                </el-form-item>
                <el-form-item label="产品名称(日语)" prop="jaName">
                    <el-input v-model="form.jaName" placeholder="请输入产品名称(日语)" />
                </el-form-item>
                <el-form-item label="产品图片" prop="fundImage">
                    <el-upload class="avatar-uploader" :multiple="false" :action="uploadImgUrl"
                        :on-success="handleUploadSuccess" :before-upload="handleBeforeUpload" :limit="1"
                        :on-error="handleUploadError" :show-file-list="false" :headers="headers">
                        <img v-if="form.fundImage" :src="form.fundImage" class="avatar">
                        <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                    </el-upload>
                </el-form-item>
                <el-form-item label="状态" prop="enabled">
                    <el-select v-model="form.enabled" placeholder="请选择状态">
                        <el-option v-for="(item, index) in ['停用', '启用']" :key="index" :label="item"
                            :value="index"></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="周期" prop="periodDay">
                    <el-input v-model="form.periodDay" placeholder="请输入周期">
                        <div slot="suffix">天</div>
                    </el-input>
                </el-form-item>
                <el-form-item label="日利率" prop="">
                    <el-row>
                        <el-col :span="11">
                            <el-input v-model="form.dayRateFront" placeholder="">
                            </el-input>
                        </el-col>
                        <el-col :span="2" style="text-align: center;">
                            --
                        </el-col>
                        <el-col :span="11">
                            <el-input v-model="form.dayRateBehind" placeholder="">
                                <div slot="suffix">%</div>
                            </el-input>
                        </el-col>
                    </el-row>
                </el-form-item>
                <el-form-item label="今日利率" prop="todayRate">
                    <el-input v-model="form.todayRate" placeholder="请输入今日利率" />
                </el-form-item>
                <el-form-item label="违约结算比例" prop="defaultRatio">
                    <el-input v-model="form.defaultRatio" placeholder="请输入违约结算比例" />
                </el-form-item>
                <el-form-item label="投资金额区间" prop="">
                    <el-row>
                        <el-col :span="11">
                            <el-input v-model="form.investmentAmountFront" placeholder="">
                            </el-input>
                        </el-col>
                        <el-col :span="2" style="text-align: center;">
                            --
                        </el-col>
                        <el-col :span="11">
                            <el-input v-model="form.investmentAmountBehind" placeholder="">
                                <div slot="suffix">USDT</div>
                            </el-input>
                        </el-col>
                    </el-row>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button type="primary" @click="submitForm">确 定</el-button>
                <el-button @click="cancel">取 消</el-button>
            </div>
        </el-dialog>
    </div>
</template>
  
<script>
import { listProduct, addProduct, updateProduct,delProduct } from "@/api/system/fund/product";
import { getToken } from "@/utils/auth";
import axios from 'axios'

export default {
    name: "ContontractControlractOrder",
    dicts: ['heyue_jiaoyi_type', 'heyue_status', 'heyue_order_type', 'pingcang_type'],
    data() {
        return {
            uploadImgUrl: axios.defaults.baseURL + "/common/upload", // 上传的图片服务器地址
            headers: {
                Authorization: "Bearer " + getToken(),
            },
            // 遮罩层
            loading: true,
            // 选中数组
            ids: [],
            // 非单个禁用
            single: true,
            // 非多个禁用
            multiple: true,
            // 显示搜索条件
            showSearch: true,
            // 总条数
            total: 0,
            // 合约订单表格数据
            contractOrderList: [],
            // 弹出层标题
            title: "",
            // 是否显示弹出层
            open: false,
            // 查询参数
            queryParams: {
                pageNum: 1,
                pageSize: 10,
                name: null
            },
            // 表单参数
            form: {
                fundImage: ''
            },
            // 表单校验
            rules: {
            }
        };
    },
    created() {
        this.getList();
    },
    methods: {
        handleUploadSuccess(res) {
            console.log('handleUploadSuccess', res)
            if (res.code == 200) {
                // this.form.fundImage = res.url
                this.$set(this.form, "fundImage", res.url)
                console.log('this.form', this.form)
            }
            this.$modal.closeLoading();
        },
        // 上传前loading加载
        handleBeforeUpload(file) {
            this.$modal.loading("正在上传中，请稍候...");
        },
        // 上传失败
        handleUploadError() {
            this.$modal.msgError("上传失败，请重试！");
            this.$modal.closeLoading();
        },
        orderStateFilter(state) {
            if (state == 'POSITIONS') {
                return '持仓'
            } else if (state == 'CLOSEOUT') {
                return '平仓'
            } else if (state == 'ENTRUSTCOMPLETE') {
                return '委托'
            }
        },
        handleWin(row) {
            this.form = {
                id: row.id + '',
                control: row.isControl,
                win: row.isWin
            }
            this.$nextTick(() => {
                this.open = true
            })
            console.log('this.form', this.form)
            // this.form.id = row.id
            // this.form.win = row.win

        },
        /** 查询合约订单列表 */
        getList() {
            this.loading = true;
            listProduct(this.queryParams).then(response => {
                this.contractOrderList = response.rows;
                this.total = response.total;
                this.loading = false;
            });
        },
        // 取消按钮
        cancel() {
            this.open = false;
            this.reset();
        },
        // 表单重置
        reset() {
            this.form = {
                id: null,
                zhName: null,
                zhTwName: null,
                enName: null,
                koName: null,
                jaName: null,
                fundImage: null,
                periodDay: null,
                dayRateFront: null,
                dayRateBehind: null,
                todayRate: null,
                defaultRatio: null,
                investmentAmountFront: null,
                investmentAmountBehind: null,
                numAstrict: null,
                enabled: null,
                createTime: null,
                updateTime: null
            };
            this.resetForm("form");
        },
        /** 搜索按钮操作 */
        handleQuery() {
            this.queryParams.pageNum = 1;
            this.getList();
        },
        /** 重置按钮操作 */
        resetQuery() {
            this.resetForm("queryForm");
            this.handleQuery();
        },
        // 多选框选中数据
        handleSelectionChange(selection) {
            this.ids = selection.map(item => item.id)
            this.single = selection.length !== 1
            this.multiple = !selection.length
        },
        /** 新增按钮操作 */
        handleAdd() {
            this.reset();
            this.form.enabled = 1
            this.open = true;
            this.title = "添加理财产品";
        },
        /** 修改按钮操作 */
        handleUpdate(row) {
            this.form = row;
            this.open = true;
            this.title = "修改理财产品";
        },
        /** 提交按钮 */
        submitForm() {
            this.$refs["form"].validate(valid => {
                if (valid) {
                    if (this.form.id != null) {
                        updateProduct(this.form).then(response => {
                            this.$modal.msgSuccess("修改成功");
                            this.open = false;
                            this.getList();
                        });
                    } else {
                        addProduct(this.form).then(response => {
                            this.$modal.msgSuccess("新增成功");
                            this.open = false;
                            this.getList();
                        });
                    }
                }
            });
        },
        /** 删除按钮操作 */
        handleDelete(row) {
            const ids = row.id || this.ids;
            this.$modal.confirm('是否确认删除理财产品编号为"' + ids + '"的数据项？').then(function () {
                return delProduct(ids);
            }).then(() => {
                this.getList();
                this.$modal.msgSuccess("删除成功");
            }).catch(() => { });
        },
        /** 导出按钮操作 */
        handleExport() {
            this.download('system/contractOrder/export', {
                ...this.queryParams
            }, `contractOrder_${new Date().getTime()}.xlsx`)
        }
    }
};
</script>

<style>
.avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
}

.avatar-uploader .el-upload:hover {
    border-color: #409EFF;
}

.avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 178px;
    height: 178px;
    line-height: 178px;
    text-align: center;
}

.avatar {
    width: 178px;
    height: 178px;
    display: block;
}
</style>
  