<template>
    <div class="app-container">
        <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="100px">
            <el-form-item label="订单号" prop="orderNo">
                <el-input v-model="queryParams.orderNo" placeholder="请输入订单号" clearable @keyup.enter.native="handleQuery" />
            </el-form-item>
            <el-form-item label="用户" prop="user">
                <el-input v-model="queryParams.user" placeholder="请输入用户名、uid" clearable @keyup.enter.native="handleQuery" />
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
            <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>

        <el-table v-loading="loading" :data="contractOrderList" @selection-change="handleSelectionChange">
            <el-table-column label="订单号" prop="orderNumber" width="180" />
            <el-table-column label="用户名" prop="uname" />
            <el-table-column label="UID" prop="uid" />
            <el-table-column label="订单类型" prop="productName" />
            <el-table-column label="借款金额" prop="productNameEn" />
            <el-table-column label="订单状态" prop="price" />
            <el-table-column label="贷款币种" prop="price" />
            <el-table-column label="质押率" prop="valueDate" />
            <el-table-column label="总负债" prop="startTime" />
            <el-table-column label="总利息" prop="endTime" />
            <el-table-column label="时利率" prop="finishValueDate" />
            <el-table-column label="借款周期" prop="finishValueDate" />
            <el-table-column label="借款时间" prop="finishValueDate" />
            <el-table-column label="到期时间" prop="finishValueDate" />
        </el-table>

        <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNum" :limit.sync="queryParams.pageSize"
            @pagination="getList" />

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
            statusOptions: ['全部', '计息中', '已结清', '强平结清'],
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
        handleReset() {

        },
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
                // this.contractOrderList = response.rows;
                this.contractOrderList = [];
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
  