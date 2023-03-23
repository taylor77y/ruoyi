<template>
  <div class="app-container">

    <el-row :gutter="10" class="mb8">
      <!-- <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:balance:add']"
        >新增</el-button>
      </el-col> -->
      <!-- <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:balance:edit']"
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
          v-hasPermi="['system:balance:remove']"
        >删除</el-button>
      </el-col> -->
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:balance:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="balanceList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <!-- <el-table-column label="ID" align="center" prop="id" /> -->
      <el-table-column label="币种" align="center" prop="currency" />
      <el-table-column label="总数" align="center" prop="sum" />
      <el-table-column label="币币可用" align="center" prop="bibikeyong" />
      <el-table-column label="币币冻结" align="center" prop="bibidongjie" />
      <el-table-column label="充提可用" align="center" prop="chongtikeyong" />
      <el-table-column label="充提冻结" align="center" prop="chongtidongjie" />
      <el-table-column label="合约可用" align="center" prop="heyuekeyong" />
      <el-table-column label="合约冻结" align="center" prop="heyuedongjie" />
      <el-table-column label="法币可用" align="center" prop="fabikeyong" />
      <el-table-column label="法币冻结" align="center" prop="fabidongjie" />
      <el-table-column label="恋上资产" align="center" prop="chainbalance" />
      <!-- <el-table-column label="备注" align="center" prop="remarks" /> -->
      <!-- <el-table-column label="创建时间" align="center" prop="createTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createTime) }}</span>
        </template>
      </el-table-column> -->
      <!-- <el-table-column label="更新时间" align="center" prop="updateTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.updateTime) }}</span>
        </template>
      </el-table-column> -->
      <!-- <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:balance:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:balance:remove']"
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

    <!-- 添加或修改用户余额对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="用户id" prop="userId">
          <el-input v-model="form.userId" disabled placeholder="请输入用户id" />
        </el-form-item>
        <el-form-item label="币种" prop="currency">
          <el-input v-model="form.currency" placeholder="请输入币种" />
        </el-form-item>
        <el-form-item label="冻结余额" prop="blockedBalance">
          <el-input v-model="form.blockedBalance" placeholder="请输入冻结余额" />
        </el-form-item>
        <el-form-item label="币币余额" prop="balance">
          <el-input v-model="form.balance" placeholder="请输入币币余额" />
        </el-form-item>
        <el-form-item label="资产冻结" prop="assetsBlockedBalance">
          <el-input v-model="form.assetsBlockedBalance" placeholder="请输入资产冻结" />
        </el-form-item>
        <el-form-item label="充提可用" prop="assetsBalance">
          <el-input v-model="form.assetsBalance" placeholder="请输入充提可用" />
        </el-form-item>
        <el-form-item label="合约可用" prop="tokenBalance">
          <el-input v-model="form.tokenBalance" placeholder="请输入合约可用" />
        </el-form-item>
        <el-form-item label="合约冻结" prop="tokenBlockedBalance">
          <el-input v-model="form.tokenBlockedBalance" placeholder="请输入合约冻结" />
        </el-form-item>
        <el-form-item label="法币可用" prop="fbBalance">
          <el-input v-model="form.fbBalance" placeholder="请输入法币可用" />
        </el-form-item>
        <el-form-item label="法币冻结" prop="fbBlockedBalance">
          <el-input v-model="form.fbBlockedBalance" placeholder="请输入法币冻结" />
        </el-form-item>
        <el-form-item label="私募冻结" prop="raiseBalance">
          <el-input v-model="form.raiseBalance" placeholder="请输入私募冻结" />
        </el-form-item>
        <el-form-item label="恋上资产" prop="chainBalance">
          <el-input v-model="form.chainBalance" placeholder="请输入恋上资产" />
        </el-form-item>
        <el-form-item label="备注" prop="remarks">
          <el-input v-model="form.remarks" placeholder="请输入备注" />
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
import { listBalance, getBalance, delBalance, addBalance, updateBalance } from "@/api/system/Bizhongzongshu";

export default {
  name: "Balance",
  dicts:['balance_order'],
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
      // 用户余额表格数据
      balanceList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        userId: null,
        currency: null,
        blockedBalance: null,
        balance: null,
        assetsBlockedBalance: null,
        assetsBalance: null,
        tokenBalance: null,
        tokenBlockedBalance: null,
        fbBalance: null,
        fbBlockedBalance: null,
        raiseBalance: null,
        chainBalance: null,
        remarks: null,
        phone:null,
        mail:null,
        orderByColumn:null,
        isAsc:null,
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
    /** 查询用户余额列表 */
    getList() {
      this.loading = true;
      if(this.queryParams.orderByColumn != null){
        this.queryParams.isAsc = "descending"
      }
      listBalance(this.queryParams).then(response => {
        this.balanceList = response.rows;
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
        userId: null,
        currency: null,
        blockedBalance: null,
        balance: null,
        assetsBlockedBalance: null,
        assetsBalance: null,
        tokenBalance: null,
        tokenBlockedBalance: null,
        fbBalance: null,
        fbBlockedBalance: null,
        raiseBalance: null,
        chainBalance: null,
        remarks: null,
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
      this.title = "添加用户余额";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getBalance(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改用户余额";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateBalance(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addBalance(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除用户余额编号为"' + ids + '"的数据项？').then(function() {
        return delBalance(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/balance/export', {
        ...this.queryParams
      }, `balance_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
