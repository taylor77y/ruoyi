<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="收款账号(链接)" prop="account">
        <el-input
          v-model="queryParams.account"
          placeholder="请输入收款账号(链接)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="收款名称(链名)" prop="username">
        <el-input
          v-model="queryParams.username"
          placeholder="请输入收款名称(链名)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="邮箱" prop="email">
        <el-input
          v-model="queryParams.email"
          placeholder="请输入邮箱"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="账户状态" prop="status">
        <el-select v-model="queryParams.status" placeholder="请选择账户状态" clearable>
          <el-option
            v-for="dict in dict.type.money_amount_status"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="银行卡名称" prop="bankname">
        <el-input
          v-model="queryParams.bankname"
          placeholder="请输入银行卡名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="账户类型" prop="type">
        <el-select v-model="queryParams.type" placeholder="请选择账户类型" clearable>
          <el-option
            v-for="dict in dict.type.money_amount_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
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
          v-hasPermi="['system:moneyAccount:add']"
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
          v-hasPermi="['system:moneyAccount:edit']"
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
          v-hasPermi="['system:moneyAccount:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:moneyAccount:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="moneyAccountList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="ID" align="center" prop="id" />
      <el-table-column label="收款账号(链接)" align="center" prop="account" />
      <el-table-column label="收款名称(链名)" align="center" prop="username" />
      <!-- <el-table-column label="二维码" align="center" prop="qrcode" width="100">
        <template slot-scope="scope">
          <image-preview :src="scope.row.qrcode" :width="50" :height="50"/>
        </template>
      </el-table-column> -->
      <el-table-column label="邮箱" align="center" prop="email" />
      <el-table-column label="账户状态" align="center" prop="status">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.money_amount_status" :value="scope.row.status"/>
        </template>
      </el-table-column>
      <el-table-column label="银行卡名称" align="center" prop="bankname" />
      <el-table-column label="账户类型" align="center" prop="type">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.money_amount_type" :value="scope.row.type"/>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:moneyAccount:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:moneyAccount:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改收款账户对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="120px">
        <el-form-item label="收款账号(链接)" prop="account">
          <el-input v-model="form.account" placeholder="请输入收款账号(链接)" />
        </el-form-item>
        <el-form-item label="收款名称(链名)" prop="username">
          <el-input v-model="form.username" placeholder="请输入收款名称(链名)" />
        </el-form-item>
        <!-- <el-form-item label="二维码">
          <image-upload v-model="form.qrcode"/>
        </el-form-item> -->
        <el-form-item label="邮箱" prop="email">
          <el-input v-model="form.email" placeholder="请输入邮箱" />
        </el-form-item>
        <el-form-item label="账户状态" prop="status">
          <el-select v-model="form.status" placeholder="请选择账户状态">
            <el-option
              v-for="dict in dict.type.money_amount_status"
              :key="dict.value"
              :label="dict.label"
:value="parseInt(dict.value)"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="银行卡名称" prop="bankname">
          <el-input v-model="form.bankname" placeholder="请输入银行卡名称" />
        </el-form-item>
        <el-form-item label="账户类型" prop="type">
          <el-select v-model="form.type" placeholder="请选择账户类型">
            <el-option
              v-for="dict in dict.type.money_amount_type"
              :key="dict.value"
              :label="dict.label"
:value="parseInt(dict.value)"
            ></el-option>
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
import { listMoneyAccount, getMoneyAccount, delMoneyAccount, addMoneyAccount, updateMoneyAccount } from "@/api/system/moneyAccount";
import { checkOperPwd} from "@/api/census";
export default {
  name: "MoneyAccount",
  dicts: ['money_amount_status', 'money_amount_type'],
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
      // 收款账户表格数据
      moneyAccountList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        account: null,
        username: null,
        qrcode: null,
        email: null,
        status: null,
        bankname: null,
        type: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        account: [
          { required: true, message: "收款账号(链接)不能为空", trigger: "blur" }
        ],
        username: [
          { required: true, message: "收款名称(链名)不能为空", trigger: "blur" }
        ],
        status: [
          { required: true, message: "账户状态不能为空", trigger: "change" }
        ],
        createTime: [
          { required: true, message: "创建时间不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询收款账户列表 */
    getList() {
      this.loading = true;
      listMoneyAccount(this.queryParams).then(response => {
        this.moneyAccountList = response.rows;
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
        account: null,
        username: null,
        qrcode: null,
        email: null,
        status: null,
        createTime: null,
        bankname: null,
        type: null
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
      this.$prompt('请输入操作密码', "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        closeOnClickModal: false,
      }).then(({ value }) => {
        checkOperPwd(value).then(res=>{
          console.log("操作密码结果",res)
          if(res.data == false){
            this.$message.error('操作密码错误，请重试');
          }else{
            this.reset();
            this.open = true;
            this.title = "添加收款账户";
          }
        })
      }).catch(() => {});
      
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.$prompt('请输入操作密码', "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        closeOnClickModal: false,
      }).then(({ value }) => {
        checkOperPwd(value).then(res=>{
          if(res.data == false){
            this.$message.error('操作密码错误，请重试');
          }else{
            this.$modal.msgSuccess("验证成功");
            this.reset();
            const id = row.id || this.ids
            getMoneyAccount(id).then(response => {
              this.form = response.data;
              this.open = true;
              this.title = "修改收款账户";
            });
          }
        })
      }).catch(() => {});
      
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateMoneyAccount(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addMoneyAccount(this.form).then(response => {
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
      this.$prompt('请输入操作密码', "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        closeOnClickModal: false,
      }).then(({ value }) => {
        checkOperPwd(value).then(res=>{
          console.log("操作密码结果",res)
          if(res.data == false){
            this.$message.error('操作密码错误，请重试');
          }else{
            this.$modal.msgSuccess("验证成功");
            const ids = row.id || this.ids;
            this.$modal.confirm('是否确认删除收款账户编号为"' + ids + '"的数据项？').then(function() {
              return delMoneyAccount(ids);
            }).then(() => {
              this.getList();
              this.$modal.msgSuccess("删除成功");
            }).catch(() => {});
          }
        })
      }).catch(() => {});
    
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/moneyAccount/export', {
        ...this.queryParams
      }, `moneyAccount_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
