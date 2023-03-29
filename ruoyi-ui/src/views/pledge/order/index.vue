<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="订单号" prop="orderNumber">
        <el-input
          v-model="queryParams.orderNumber"
          placeholder="请输入订单号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="状态" prop="status">
        <el-select v-model="queryParams.status" placeholder="请选择">
          <el-option v-for="(item, index) in statusOptions" :key="index" :label="item" :value="index - 1"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>

    </el-form>
    <el-table v-loading="loading" :data="orderList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="订单号" width="180" align="center" prop="orderNumber">
        <template slot-scope="scope">
          <el-link type="primary" @click="handleDetail(scope.row)">{{scope.row.orderNumber}}</el-link>
        </template>
      </el-table-column>
      <el-table-column label="借款金额" align="center" prop="borrowMoney" />
      <el-table-column label="订单状态" align="center" prop="status" >
        <template slot-scope="scope">
          <el-tag>{{ statusOptions[scope.row.status + 1] }}</el-tag>
        </template>
      </el-table-column>
      <el-table-column label="借款币种" align="center" prop="borrowName"/>
      <el-table-column label="质押金额" align="center" prop="pledgeMoney" />
      <el-table-column label="质押币种" align="center" prop="pledgeName" />
      <el-table-column label="质押率" align="center" prop="pledgeRate" />
      <el-table-column label="总利息" align="center" prop="totalMoney" />
      <el-table-column label="总负债" align="center" prop="totalIncurDebts" />
      <el-table-column label="借款周期" align="center" prop="deadline" />
      <el-table-column label="小时利率" align="center" prop="hrRate" />
      <el-table-column label="借款时间" align="center" prop="creationTime" width="180"></el-table-column>
      <el-table-column label="到期时间" align="center" prop="expireTime" width="180"></el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />
    <!-- 添加或修改质押借币订单对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="1000px" append-to-body>
      <el-table v-loading="loading" :data="gridData">
        <el-table-column label="订单类型" align="center" prop="type" :formatter=formatter>
        </el-table-column>
        <el-table-column label="金额" align="center" prop="money"/>
        <el-table-column label="质押类型" align="center" prop="pledgeType" />
        <el-table-column label="质押金额" align="center" prop="pledgePrice" />
        <el-table-column label="质押币种" align="center" prop="pledgeName" />
        <el-table-column label="创建时间" align="center" prop="creationTime" width="180"></el-table-column>
      </el-table>
    </el-dialog>
  </div>
</template>

<script>
import { listOrder } from "@/api/system/pledge/order";
import { getToken } from "@/utils/auth";
import axios from 'axios'


export default {
  name: "Order",
  data() {
    return {
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
      // 质押借币订单表格数据
      orderList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        memberId: null,
        orderNumber: null,
        status: -1
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      },
      statusOptions: ['全部','计息中', '已结算', '已强赎'],
      gridData:[],
    };
  },
  created() {
    this.getList();
  },
  methods: {
    formatter(row, column, cellValue, index){
      if (cellValue=="BORROW"){
          return <el-tag effect="dark" type="warning">借款</el-tag>
      }else if (cellValue=="REFUND"){
          return <el-tag effect="dark" type="">还款</el-tag>
      }else if (cellValue=="RENEWAL"){
        return <el-tag effect="dark" type="success" color="#33577b">续借</el-tag>
      }else {
        return <el-tag effect="dark" type="success">新增质押</el-tag>
      }
    },
    submitForm(){},
    /** 查询质押借币订单列表 */
    getList() {
      this.loading = true;
      listOrder(this.queryParams).then(response => {
        this.orderList = response.rows;
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
        memberId: null,
        orderNumber: null,
        borrowMoney: null,
        borrowName: null,
        pledgeMoney: null,
        pledgeName: null,
        deadline: null,
        forcePrice: null,
        pledgeRate: null,
        hrRate: null,
        dayRate: null,
        feeMoney: null,
        totalMoney: null,
        totalIncurDebts: null,
        predictRefundMoney: null,
        refundPrice: null,
        creationTime: null,
        expireTime: null,
        updateTime: null,
        status: 0
      };
      this.resetForm("form");
    },

    handleDetail(row){
      this.gridData=row.details;
      console.log("数据数据"+this.gridData);
      this.open = true;
      this.title = "订单详情";
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
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.form.enabled = 1
      this.open = true;
      this.title = "添加理财产品";
    },

    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },

    /** 导出按钮操作 */
    handleExport() {
      this.download('system/order/export', {
        ...this.queryParams
      }, `order_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
