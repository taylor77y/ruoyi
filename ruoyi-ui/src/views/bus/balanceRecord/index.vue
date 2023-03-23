<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="88px">
      <el-form-item label="用户UUID" prop="uuid">
        <el-input
          v-model="queryParams.uuid"
          placeholder="请输入用户UUID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="手机号" prop="phone">
        <el-input
          v-model="queryParams.phone"
          placeholder="请输入用户手机号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="币种" prop="currency">
        <el-input
          v-model="queryParams.currency"
          placeholder="请输入币种"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="资金类型" prop="balanceType">
        <el-select v-model="queryParams.balanceType" placeholder="请选择资金类型" clearable>
          <el-option
            v-for="dict in dict.type.amount_change_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="交易类型" prop="fundsType">
        <el-select v-model="queryParams.fundsType" placeholder="请选择交易类型" clearable>
          <el-option
            v-for="dict in dict.type.zj_funds_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="数据类型" prop="dataClassification">
        <el-select v-model="queryParams.dataClassification" placeholder="请选择数据类型" clearable>
          <el-option
            v-for="dict in dict.type.zj_change_data_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <!-- <el-form-item label="资产变更前" prop="balanceBefore">
        <el-input
          v-model="queryParams.balanceBefore"
          placeholder="请输入资产变更前"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="资产变更后" prop="balanceBack">
        <el-input
          v-model="queryParams.balanceBack"
          placeholder="请输入资产变更后"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="资产差额" prop="balanceDifference">
        <el-input
          v-model="queryParams.balanceDifference"
          placeholder="请输入资产差额"
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
          v-hasPermi="['system:balanceRecord:add']"
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
          v-hasPermi="['system:balanceRecord:edit']"
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
          v-hasPermi="['system:balanceRecord:remove']"
        >删除</el-button>
      </el-col> -->
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:balanceRecord:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="balanceRecordList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="ID" align="center" prop="id" />
      <el-table-column label="用户UUID" align="center" prop="uuid" />
      <el-table-column label="手机号" align="center" prop="phone" />
      <el-table-column label="币种" align="center" prop="currency" />
      <el-table-column label="资金类型" align="center" prop="balanceType">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.amount_change_type" :value="scope.row.balanceType"/>
        </template>
      </el-table-column>
      <el-table-column label="交易类型" align="center" prop="fundsType">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.zj_funds_type" :value="scope.row.fundsType"/>
        </template>
      </el-table-column>
      <el-table-column label="数据类型" align="center" prop="dataClassification">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.zj_change_data_type" :value="scope.row.dataClassification"/>
        </template>
      </el-table-column>
      <el-table-column label="资产变更前" align="center" prop="balanceBefore" />
      <el-table-column label="资产变更后" align="center" prop="balanceBack" />
      <el-table-column label="资产差额" align="center" prop="balanceDifference" />
      <el-table-column label="创建时间" align="center" prop="createTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createTime) }}</span>
        </template>
      </el-table-column>
      <!-- <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:balanceRecord:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:balanceRecord:remove']"
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

    <!-- 添加或修改资金记录对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="用户ID" prop="memberId">
          <el-input v-model="form.memberId" placeholder="请输入用户ID" />
        </el-form-item>
        <el-form-item label="币种" prop="currency">
          <el-input v-model="form.currency" placeholder="请输入币种" />
        </el-form-item>
        <el-form-item label="资金类型" prop="balanceType">
          <el-select v-model="form.balanceType" placeholder="请选择资金类型">
            <el-option
              v-for="dict in dict.type.amount_change_type"
              :key="dict.value"
              :label="dict.label"
:value="parseInt(dict.value)"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="交易类型" prop="fundsType">
          <el-select v-model="form.fundsType" placeholder="请选择交易类型">
            <el-option
              v-for="dict in dict.type.zj_funds_type"
              :key="dict.value"
              :label="dict.label"
:value="parseInt(dict.value)"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="资产变更前" prop="balanceBefore">
          <el-input v-model="form.balanceBefore" placeholder="请输入资产变更前" />
        </el-form-item>
        <el-form-item label="资产变更后" prop="balanceBack">
          <el-input v-model="form.balanceBack" placeholder="请输入资产变更后" />
        </el-form-item>
        <el-form-item label="资产差额" prop="balanceDifference">
          <el-input v-model="form.balanceDifference" placeholder="请输入资产差额" />
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
import { listBalanceRecord, getBalanceRecord, delBalanceRecord, addBalanceRecord, updateBalanceRecord } from "@/api/system/balanceRecord";

export default {
  name: "BalanceRecord",
  dicts: ['amount_change_type', 'zj_funds_type','zj_change_data_type'],
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
      // 资金记录表格数据
      balanceRecordList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        memberId: null,
        currency: null,
        balanceType: null,
        fundsType: null,
        balanceBefore: null,
        balanceBack: null,
        balanceDifference: null,
        uuid:null,
        phone:null,
        dataClassification:null,
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
    /** 查询资金记录列表 */
    getList() {
      this.loading = true;
      listBalanceRecord(this.queryParams).then(response => {
        this.balanceRecordList = response.rows;
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
        currency: null,
        balanceType: null,
        fundsType: null,
        balanceBefore: null,
        balanceBack: null,
        balanceDifference: null,
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
      this.title = "添加资金记录";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getBalanceRecord(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改资金记录";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateBalanceRecord(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addBalanceRecord(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除资金记录编号为"' + ids + '"的数据项？').then(function() {
        return delBalanceRecord(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/balanceRecord/export', {
        ...this.queryParams
      }, `balanceRecord_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
