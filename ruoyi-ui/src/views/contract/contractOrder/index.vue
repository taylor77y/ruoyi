<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="交易对名称" prop="pairsName">
        <el-input
          v-model="queryParams.pairsName"
          placeholder="请输入交易对名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="用户手机" prop="phone">
        <el-input
          v-model="queryParams.phone"
          placeholder="请输入用户手机"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="用户邮箱" prop="mail">
        <el-input
          v-model="queryParams.mail"
          placeholder="请输入用户邮箱"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <!-- <el-form-item label="${comment}" prop="mainCur">
        <el-input
          v-model="queryParams.mainCur"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="币种名称" prop="coinName">
        <el-input
          v-model="queryParams.coinName"
          placeholder="请输入币种名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="杠杆倍数" prop="leverNum">
        <el-input
          v-model="queryParams.leverNum"
          placeholder="请输入杠杆倍数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="杠杆描述" prop="leverDesc">
        <el-input
          v-model="queryParams.leverDesc"
          placeholder="请输入杠杆描述"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="保证金" prop="margin">
        <el-input
          v-model="queryParams.margin"
          placeholder="请输入保证金"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="手数" prop="contractHands">
        <el-input
          v-model="queryParams.contractHands"
          placeholder="请输入手数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="持仓价格" prop="price">
        <el-input
          v-model="queryParams.price"
          placeholder="请输入持仓价格"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="撮合价格" prop="matchPrice">
        <el-input
          v-model="queryParams.matchPrice"
          placeholder="请输入撮合价格"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="平仓金额" prop="matchFee">
        <el-input
          v-model="queryParams.matchFee"
          placeholder="请输入平仓金额"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="平仓类型" prop="closeType">
        <el-select v-model="queryParams.closeType" placeholder="请选择平仓类型" clearable>
          <el-option
            v-for="dict in dict.type.pingcang_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="数量" prop="coinNum">
        <el-input
          v-model="queryParams.coinNum"
          placeholder="请输入数量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="可用合约乘数" prop="isContractHands">
        <el-input
          v-model="queryParams.isContractHands"
          placeholder="请输入可用合约乘数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="状态" prop="orderState">
        <el-select v-model="queryParams.orderState" placeholder="请选择状态" clearable>
          <el-option
            v-for="dict in dict.type.heyue_status"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="手续费" prop="takeFee">
        <el-input
          v-model="queryParams.takeFee"
          placeholder="请输入手续费"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="订单类型" prop="orderType">
        <el-select v-model="queryParams.orderType" placeholder="请选择订单类型" clearable>
          <el-option
            v-for="dict in dict.type.heyue_order_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="用户" prop="member">
        <el-input
          v-model="queryParams.member"
          placeholder="请输入用户"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="交易类型" prop="tradeType">
        <el-select v-model="queryParams.tradeType" placeholder="请选择交易类型" clearable>
          <el-option
            v-for="dict in dict.type.heyue_jiaoyi_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="合约配置 ID" prop="contractMulId">
        <el-input
          v-model="queryParams.contractMulId"
          placeholder="请输入合约配置 ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="杠杆 ID" prop="leverId">
        <el-input
          v-model="queryParams.leverId"
          placeholder="请输入杠杆 ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <!-- <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:contractOrder:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:contractOrder:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:contractOrder:remove']"
        >删除</el-button>
      </el-col> -->
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:contractOrder:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="contractOrderList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <!-- <el-table-column label="ID" align="center" prop="id" /> -->
       <el-table-column label="用户手机" align="center" prop="phone" />
        <el-table-column label="用户邮箱" align="center" prop="mail" />
      <el-table-column label="交易对名称" align="center" prop="pairsName" width="150" />
     
      <el-table-column label="杠杆倍数" align="center" prop="leverNum" />
      <el-table-column label="保证金" align="center" prop="margin" />
      <el-table-column label="手数" align="center" prop="contractHands" />
      <el-table-column label="持仓价格" align="center" prop="price" />
      <el-table-column label="撮合价格" align="center" prop="matchPrice" />
      <el-table-column label="平仓金额" align="center" prop="matchFee" />
      <el-table-column label="平仓类型" align="center" prop="closeType">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.pingcang_type" :value="scope.row.closeType"/>
        </template>
      </el-table-column>
      <el-table-column label="状态" align="center" prop="orderState">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.heyue_status" :value="scope.row.orderState"/>
        </template>
      </el-table-column>
      <el-table-column label="手续费" align="center" prop="takeFee" />
      <el-table-column label="订单类型" align="center" prop="orderType">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.heyue_order_type" :value="scope.row.orderType"/>
        </template>
      </el-table-column>
      <el-table-column label="交易类型" align="center" prop="tradeType">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.heyue_jiaoyi_type" :value="scope.row.tradeType"/>
        </template>
      </el-table-column>
      <!-- <el-table-column label="币种名称" align="center" prop="coinName" />
      <el-table-column label="杠杆描述" align="center" prop="leverDesc" />
      <el-table-column label="价格类型" align="center" prop="priceType" />
      <el-table-column label="数量" align="center" prop="coinNum" />
      <el-table-column label="可用合约乘数" align="center" prop="isContractHands" />
      <el-table-column label="用户" align="center" prop="member" />
      <el-table-column label="合约配置 ID" align="center" prop="contractMulId" />
      <el-table-column label="杠杆 ID" align="center" prop="leverId" />
      <el-table-column label="创建时间" align="center" prop="createTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:contractOrder:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:contractOrder:remove']"
          >删除</el-button>
        </template>
      </el-table-column> -->
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改合约订单对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="交易对名称" prop="pairsName">
          <el-input v-model="form.pairsName" placeholder="请输入交易对名称" />
        </el-form-item>
        <el-form-item label="${comment}" prop="mainCur">
          <el-input v-model="form.mainCur" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="币种名称" prop="coinName">
          <el-input v-model="form.coinName" placeholder="请输入币种名称" />
        </el-form-item>
        <el-form-item label="杠杆倍数" prop="leverNum">
          <el-input v-model="form.leverNum" placeholder="请输入杠杆倍数" />
        </el-form-item>
        <el-form-item label="杠杆描述" prop="leverDesc">
          <el-input v-model="form.leverDesc" placeholder="请输入杠杆描述" />
        </el-form-item>
        <el-form-item label="保证金" prop="margin">
          <el-input v-model="form.margin" placeholder="请输入保证金" />
        </el-form-item>
        <el-form-item label="手数" prop="contractHands">
          <el-input v-model="form.contractHands" placeholder="请输入手数" />
        </el-form-item>
        <el-form-item label="持仓价格" prop="price">
          <el-input v-model="form.price" placeholder="请输入持仓价格" />
        </el-form-item>
        <el-form-item label="撮合价格" prop="matchPrice">
          <el-input v-model="form.matchPrice" placeholder="请输入撮合价格" />
        </el-form-item>
        <el-form-item label="平仓金额" prop="matchFee">
          <el-input v-model="form.matchFee" placeholder="请输入平仓金额" />
        </el-form-item>
        <el-form-item label="平仓类型" prop="closeType">
          <el-select v-model="form.closeType" placeholder="请选择平仓类型">
            <el-option
              v-for="dict in dict.type.pingcang_type"
              :key="dict.value"
              :label="dict.label"
:value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="数量" prop="coinNum">
          <el-input v-model="form.coinNum" placeholder="请输入数量" />
        </el-form-item>
        <el-form-item label="可用合约乘数" prop="isContractHands">
          <el-input v-model="form.isContractHands" placeholder="请输入可用合约乘数" />
        </el-form-item>
        <el-form-item label="状态" prop="orderState">
          <el-select v-model="form.orderState" placeholder="请选择状态">
            <el-option
              v-for="dict in dict.type.heyue_status"
              :key="dict.value"
              :label="dict.label"
:value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="手续费" prop="takeFee">
          <el-input v-model="form.takeFee" placeholder="请输入手续费" />
        </el-form-item>
        <el-form-item label="订单类型" prop="orderType">
          <el-select v-model="form.orderType" placeholder="请选择订单类型">
            <el-option
              v-for="dict in dict.type.heyue_order_type"
              :key="dict.value"
              :label="dict.label"
:value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="用户" prop="member">
          <el-input v-model="form.member" placeholder="请输入用户" />
        </el-form-item>
        <el-form-item label="交易类型" prop="tradeType">
          <el-select v-model="form.tradeType" placeholder="请选择交易类型">
            <el-option
              v-for="dict in dict.type.heyue_jiaoyi_type"
              :key="dict.value"
              :label="dict.label"
:value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="合约配置 ID" prop="contractMulId">
          <el-input v-model="form.contractMulId" placeholder="请输入合约配置 ID" />
        </el-form-item>
        <el-form-item label="杠杆 ID" prop="leverId">
          <el-input v-model="form.leverId" placeholder="请输入杠杆 ID" />
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
import { listContractOrder, getContractOrder, delContractOrder, addContractOrder, updateContractOrder } from "@/api/system/contractOrder";

export default {
  name: "ContractOrder",
  dicts: ['heyue_jiaoyi_type', 'heyue_status', 'heyue_order_type', 'pingcang_type'],
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
        phone:null,
        mail:null,
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
    /** 查询合约订单列表 */
    getList() {
      this.loading = true;
      listContractOrder(this.queryParams).then(response => {
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
      this.single = selection.length!==1
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
          if (this.form.id != null) {
            updateContractOrder(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addContractOrder(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除合约订单编号为"' + ids + '"的数据项？').then(function() {
        return delContractOrder(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
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
