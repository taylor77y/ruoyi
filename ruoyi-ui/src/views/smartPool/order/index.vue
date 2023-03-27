<template>
    <div class="app-container">
        <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="100px">
            <el-form-item label="订单号" prop="orderNo">
                <el-input v-model="queryParams.orderNo" placeholder="请输入订单号" clearable @keyup.enter.native="handleQuery" />
            </el-form-item>
            <el-form-item label="用户" prop="user">
                <el-input v-model="queryParams.user" placeholder="请输入用户名、uid" clearable @keyup.enter.native="handleQuery" />
            </el-form-item>
            <el-form-item label="矿机" prop="productId">
                <el-select v-model="queryParams.productId" placeholder="请选择" clearable>
                    <el-option v-for="(item, index) in smartOptions" :key="index" :label="item.zhName" :value="item.id">
                    </el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="状态" prop="status">
                <el-select v-model="queryParams.status" placeholder="请选择">
                    <el-option v-for="(item, index) in statusOptions" :key="index" :label="item" :value="index - 1">
                    </el-option>
                </el-select>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
                <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
            </el-form-item>
        </el-form>

        <el-row :gutter="10" class="mb8">
            <el-col :span="1.5">
                <el-button type="primary" plain icon="el-icon-plus" size="mini" @click="handleAdd">新增订单</el-button>
            </el-col>
            <el-col :span="1.5" v-hasPermi="['system:fundOrder:reset']">
                <el-date-picker v-model="resetTime" type="datetime" size="mini" placeholder="系统时间">
                </el-date-picker>
                <el-button style="margin-left: 20px;" type="primary" plain icon="el-icon-refresh-right" size="mini"
                    @click="handleAdd">利息重计</el-button>
            </el-col>
            <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>

        <el-table v-loading="loading" :data="contractOrderList" @selection-change="handleSelectionChange">
            <el-table-column label="订单号" prop="orderNumber" width="180"/>
            <el-table-column label="用户名" prop="uname" />
            <el-table-column label="UID" prop="uid" />
            <el-table-column label="产品名称" prop="productName" />
            <el-table-column label="产品名称(英文)" prop="productNameEn" />
            <el-table-column label="金额" prop="price" />
            <el-table-column label="收益" prop="accumulatedIncome">
                <template slot-scope="{row}">
                    <el-tag>{{ row.accumulatedIncome || 0 }}</el-tag>
                </template>
            </el-table-column>
            <el-table-column label="买入时间" prop="valueDate" />
            <el-table-column label="开始时间" prop="startTime" />
            <el-table-column label="结束时间" prop="endTime" />
            <el-table-column label="赎回时间" prop="finishValueDate" />
            <el-table-column label="状态" prop="enabled">
                <template slot-scope="scope">
                    <el-tag>{{ statusOptions[scope.row.enabled + 1] }}</el-tag>
                </template>
            </el-table-column>
        </el-table>

        <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNum" :limit.sync="queryParams.pageSize"
            @pagination="getList" />

        <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
            <el-form ref="form" :model="form" :rules="rules" label-width="100px">
                <el-form-item label="矿机" prop="productId">
                    <el-select v-model="form.productId" placeholder="请选择矿机" @change="smartChange">
                        <el-option v-for="(item, index) in smartOptions" :key="index" :label="item.zhName" :value="item.id">
                        </el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="投资金额区间" prop="" v-show="form.productId && form.product">
                    <el-row>
                        <el-col :span="11">
                            <el-input v-model="form.product.investmentAmountFront" placeholder="" :disabled="true">
                            </el-input>
                        </el-col>
                        <el-col :span="2" style="text-align: center;">
                            --
                        </el-col>
                        <el-col :span="11">
                            <el-input v-model="form.product.investmentAmountBehind" placeholder="" :disabled="true">
                                <div slot="suffix">USDT</div>
                            </el-input>
                        </el-col>
                    </el-row>
                </el-form-item>
                <el-form-item label="用户uid" prop="memberId">
                    <el-input v-model="form.memberId" placeholder="请输入用户uid" />
                </el-form-item>
                <el-form-item label="投资金额" prop="price">
                    <el-input v-model="form.price" placeholder="请输入投资金额" />
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
import { listOrder, addOrder } from "@/api/system/smartPool/order";
import { listProduct } from "@/api/system/smartPool/product";
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
                orderNo: null,
                name: null,
                user: null,
                status: -1
            },
            // 表单参数
            form: {
                fundImage: '',
                product: {}
            },
            // 表单校验
            rules: {
                productId: [
                    { required: true, message: "请选择矿机", trigger: "blur" }
                ],
                memberId: [
                    { required: true, message: "请输入用户UID", trigger: "blur" }
                ],
                price: [
                    { required: true, message: "请输入价格", trigger: "blur" }
                ]
            },
            statusOptions: ['全部', '赎回', '托管中'],
            resetTime: null,
            smartOptions: []
        };
    },
    created() {
        this.getList();
        listProduct().then(res => {
            if (res.code == 200) {
                this.smartOptions = res.rows
            }
            // console.log('listProduct', res)
        })
    },
    methods: {
        smartChange(val) {
            // console.log('smartChange',val)
            for (let obj of this.smartOptions) {
                if (obj.id == val) {
                    this.form.product = obj
                    return
                }
            }
        },
        /** 查询合约订单列表 */
        getList() {
            this.loading = true;
            listOrder(this.queryParams).then(response => {
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
                productId: null,
                memberId: null,
                price: null,
                product: {}
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
            this.open = true;
            this.title = "添加矿机订单";
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
                    addOrder(this.form).then(response => {
                        this.$modal.msgSuccess("新增成功");
                        this.open = false;
                        this.getList();
                    });
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
  