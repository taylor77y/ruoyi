<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <!-- <el-form-item label="提币用户ID" prop="member">
        <el-input
          v-model="queryParams.member"
          placeholder="请输入提币用户ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
      <el-form-item label="区块高度" prop="blockNumber">
        <el-input
          v-model="queryParams.blockNumber"
          placeholder="请输入区块高度"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="交易hash" prop="txHash">
        <el-input
          v-model="queryParams.txHash"
          placeholder="请输入交易hash"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="合约地址" prop="contract">
        <el-input
          v-model="queryParams.contract"
          placeholder="请输入合约地址"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="转出地址" prop="fromAddress">
        <el-input
          v-model="queryParams.fromAddress"
          placeholder="请输入转出地址"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="状态" prop="status">
        <el-select v-model="queryParams.status" placeholder="请选择状态" clearable>
          <el-option
            v-for="dict in dict.type.withdraw_status"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="收币地址" prop="toAddress">
        <el-input
          v-model="queryParams.toAddress"
          placeholder="请输入收币地址"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="币名" prop="coin">
        <el-input
          v-model="queryParams.coin"
          placeholder="请输入币名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="数量" prop="amount">
        <el-input
          v-model="queryParams.amount"
          placeholder="请输入数量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:withdrawHistory:add']"
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
          v-hasPermi="['system:withdrawHistory:edit']"
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
          v-hasPermi="['system:withdrawHistory:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:withdrawHistory:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="withdrawHistoryList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="ID" align="center" prop="id" />
      <el-table-column label="用户手机" align="center" prop="phone" />
      <!-- <el-table-column label="交易区块高度" align="center" prop="blockNumber" /> -->
      <el-table-column label="交易hash" align="center" prop="txHash" />
      <!-- <el-table-column label="合约地址" align="center" prop="contract" />
      <el-table-column label="转出地址" align="center" prop="fromAddress" /> -->
      <el-table-column label="收币地址" align="center" prop="toAddress" />
      <el-table-column label="币名" align="center" prop="coin" />
      <el-table-column label="数量" align="center" prop="amount" />
      <el-table-column label="状态" align="center" prop="status">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.withdraw_status" :value="scope.row.status"/>
        </template>
      </el-table-column>
      <!-- <el-table-column label="创建时间" align="center" prop="createTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column> -->
      <!-- <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:withdrawHistory:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:withdrawHistory:remove']"
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

    <!-- 添加或修改提币记录对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="800px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="100px">
        <el-form-item label="提币用户ID" prop="member">
          <el-input v-model="form.member" placeholder="请输入提币用户ID" />
        </el-form-item>
        <el-form-item label="交易区块高度" prop="blockNumber">
          <el-input v-model="form.blockNumber" placeholder="请输入交易区块高度" />
        </el-form-item>
        <el-form-item label="交易hash" prop="txHash">
          <el-input v-model="form.txHash" placeholder="请输入交易hash" />
        </el-form-item>
        <el-form-item label="合约地址" prop="contract">
          <el-input v-model="form.contract" placeholder="请输入合约地址" />
        </el-form-item>
        <el-form-item label="转出地址" prop="fromAddress">
          <el-input v-model="form.fromAddress" placeholder="请输入转出地址" />
        </el-form-item>
        <el-form-item label="状态">
          <el-radio-group v-model="form.status">
            <el-radio
              v-for="dict in dict.type.withdraw_status"
              :key="dict.value"
:label="dict.value"
            >{{dict.label}}</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="收币地址" prop="toAddress">
          <el-input v-model="form.toAddress" placeholder="请输入收币地址" />
        </el-form-item>
        <el-form-item label="币名" prop="coin">
          <el-input v-model="form.coin" placeholder="请输入币名" />
        </el-form-item>
        <el-form-item label="数量" prop="amount">
          <el-input v-model="form.amount" placeholder="请输入数量" />
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
import { listWithdrawHistory, getWithdrawHistory, delWithdrawHistory, addWithdrawHistory, updateWithdrawHistory } from "@/api/system/withdrawHistory";

export default {
  name: "WithdrawHistory",
  dicts: ['withdraw_status'],
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
      // 提币记录表格数据
      withdrawHistoryList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        member: null,
        blockNumber: null,
        txHash: null,
        contract: null,
        fromAddress: null,
        status: null,
        toAddress: null,
        coin: null,
        amount: null,
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
    /** 查询提币记录列表 */
    getList() {
      this.loading = true;
      listWithdrawHistory(this.queryParams).then(response => {
        this.withdrawHistoryList = response.rows;
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
        member: null,
        blockNumber: null,
        txHash: null,
        contract: null,
        fromAddress: null,
        status: "WITHDRAW_SUCCESS",
        toAddress: null,
        coin: null,
        amount: null,
        createTime: null
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
      this.title = "添加提币记录";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getWithdrawHistory(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改提币记录";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateWithdrawHistory(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addWithdrawHistory(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除提币记录编号为"' + ids + '"的数据项？').then(function() {
        return delWithdrawHistory(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/withdrawHistory/export', {
        ...this.queryParams
      }, `withdrawHistory_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
