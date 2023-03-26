<template>
    <div class="app-container">
        <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="88px">
            <el-form-item label="交易币名称" prop="pairsName">
                <el-input v-model="queryParams.pairsName" placeholder="请输入交易币名称" clearable
                    @keyup.enter.native="handleQuery" />
            </el-form-item>
            <el-form-item label="用户手机" prop="phone">
                <el-input v-model="queryParams.phone" placeholder="请输入用户手机" clearable @keyup.enter.native="handleQuery" />
            </el-form-item>
            <el-form-item label="用户邮箱" prop="mail">
                <el-input v-model="queryParams.mail" placeholder="请输入用户邮箱" clearable @keyup.enter.native="handleQuery" />
            </el-form-item>
            <el-form-item label="uuid" prop="uuid">
                <el-input v-model="queryParams.uuid" placeholder="请输入uuid" clearable @keyup.enter.native="handleQuery" />
            </el-form-item>
            <el-form-item>
                <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
                <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
            </el-form-item>
        </el-form>

        <el-row :gutter="10" class="mb8">
            <!-- <el-col :span="1.5">
                <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport"
                    v-hasPermi="['system:contractOrder:export']">导出</el-button>
            </el-col> -->
            <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>

        <el-table v-loading="loading" :data="contractOrderList" @selection-change="handleSelectionChange">
            <!-- <el-table-column type="selection" width="55" align="center" /> -->
            <el-table-column label="用户uuid" align="center" prop="uuid" />
            <el-table-column label="用户手机" align="center" prop="phone" />
            <el-table-column label="用户邮箱" align="center" prop="mail" />
            <el-table-column label="交易币名称" align="center" prop="pairsName" width="150" />
            <el-table-column label="开始价" align="center" prop="kPrice" />
            <el-table-column label="结束价" align="center" prop="bPrice" />
            <el-table-column label="合约金额" align="center" prop="amount" />
            <el-table-column label="保证金" align="center" prop="margin" />
            <el-table-column label="手续费" align="center" prop="matchFee" />
            <el-table-column label="收益" align="center" prop="profit" />
            <el-table-column label="控盘价" align="center" prop="controlPrice" />
            <el-table-column label="结算状态" align="center" prop="orderState">
                <template slot-scope="scope">
                    <el-tag type="success">{{ orderStateFilter(scope.row.orderState) }}</el-tag>
                </template>
            </el-table-column>
            <el-table-column label="控盘" align="center" prop="orderState">
                <template slot-scope="scope">
                    <el-tag type="danger">{{ ['否', '是'][scope.row.isControl] }}</el-tag>
                </template>
            </el-table-column>
            <el-table-column label="输赢" align="center" prop="orderState">
                <template slot-scope="scope">
                    <el-tag>{{ ['输', '赢'][scope.row.isWin] }}</el-tag>
                </template>
            </el-table-column>
            <el-table-column label="操作" align="center" fixed="right" class-name="small-padding fixed-width">
                <template slot-scope="scope">
                    <el-button size="mini" type="text" icon="el-icon-edit" @click="handleWin(scope.row)">控盘</el-button>
                </template>
            </el-table-column>
        </el-table>

        <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNum" :limit.sync="queryParams.pageSize"
            @pagination="getList" />

        <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
            <el-form ref="form" :model="form" :rules="rules" label-width="80px">
                <el-form-item label="是否控盘" prop="control">
                    <el-select v-model="form.control" placeholder="请选择是否控盘">
                        <el-option v-for="(item, index) in ['否', '是']" :key="index" :label="item"
                            :value="index"></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="输赢控制" prop="win">
                    <el-select v-model="form.win" placeholder="请选择输赢">
                        <el-option v-for="(item, index) in ['输', '赢']" :key="index" :label="item"
                            :value="index"></el-option>
                    </el-select>
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
import { page, setControlAndWin } from "@/api/system/contract/perpetual";

export default {
    name: "ContontractControlractOrder",
    dicts: ['heyue_jiaoyi_type', 'heyue_status', 'heyue_order_type', 'pingcang_type'],
    data() {
        return {
            winOptions: ["不控制", "赢", "输"],
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
                uuid: null,
                phone: null,
                mail: null,
            },
            // 表单参数
            form: {},
            // 表单校验
            rules: {
            }
        };
    },
    created() {
        this.getList();
    },
    methods: {
        orderStateFilter(state){
            if(state == 'POSITIONS'){
                return '持仓'
            }else if(state == 'CLOSEOUT'){
                return '平仓'
            }else if(state == 'ENTRUSTCOMPLETE'){
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
            page(this.queryParams).then(response => {
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
                pairsName: null,
                mainCur: null,
                coinName: null,
                leverNum: null,
                leverDesc: null,
                margin: null,
                contractHands: null,
                price: null,
                matchPrice: null,
                matchFee: null,
                closeType: null,
                priceType: null,
                coinNum: null,
                isContractHands: null,
                orderState: null,
                takeFee: null,
                orderType: null,
                member: null,
                tradeType: null,
                contractMulId: null,
                leverId: null,
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
            this.open = true;
            this.title = "添加合约订单";
        },
        /** 修改按钮操作 */
        handleUpdate(row) {
            this.reset();
            const id = row.id || this.ids
            getContractOrder(id).then(response => {
                this.form = response.data;
                this.open = true;
                this.title = "修改合约订单";
            });
        },
        /** 提交按钮 */
        submitForm() {
            this.$refs["form"].validate(valid => {
                if (valid) {
                    setControlAndWin(this.form.id, this.form.control, this.form.win).then(res => {
                        this.$modal.msgSuccess("操盘成功");
                        this.open = false;
                        this.getList();
                    })
                }
            });
        },
        /** 删除按钮操作 */
        handleDelete(row) {
            const ids = row.id || this.ids;
            this.$modal.confirm('是否确认删除合约订单编号为"' + ids + '"的数据项？').then(function () {
                return delContractOrder(ids);
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
  