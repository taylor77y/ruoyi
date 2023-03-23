<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="币名称" prop="tokenCur">
        <el-input
          v-model="queryParams.tokenCur"
          placeholder="请输入币名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="起始价格" prop="startingPrice">
        <el-input
          v-model="queryParams.startingPrice"
          placeholder="请输入起始价格"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="结束价格" prop="finalPrice">
        <el-input
          v-model="queryParams.finalPrice"
          placeholder="请输入结束价格"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="最大交易量" prop="tradingVolumeMax">
        <el-input
          v-model="queryParams.tradingVolumeMax"
          placeholder="请输入最大交易量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="最小交易量" prop="tradingVolumeMin">
        <el-input
          v-model="queryParams.tradingVolumeMin"
          placeholder="请输入最小交易量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="状态" prop="status">
        <el-select v-model="queryParams.status" placeholder="请选择状态" clearable>
          <el-option
            v-for="dict in dict.type.zfbkz_status"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="开盘价" prop="openingPrice">
        <el-input
          v-model="queryParams.openingPrice"
          placeholder="请输入开盘价"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="收盘价" prop="closingPrice">
        <el-input
          v-model="queryParams.closingPrice"
          placeholder="请输入收盘价"
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
          v-hasPermi="['system:currencyControls:add']"
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
          v-hasPermi="['system:currencyControls:edit']"
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
          v-hasPermi="['system:currencyControls:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:currencyControls:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="currencyControlsList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="ID" align="center" prop="id" />
      <el-table-column label="币名称" align="center" prop="tokenCur" />
      <el-table-column label="起始价格" align="center" prop="startingPrice" />
      <el-table-column label="结束价格" align="center" prop="finalPrice" />
      <el-table-column label="最大交易量" align="center" prop="tradingVolumeMax" />
      <el-table-column label="最小交易量" align="center" prop="tradingVolumeMin" />
      <el-table-column label="状态" align="center" prop="status">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.zfbkz_status" :value="scope.row.status"/>
        </template>
      </el-table-column>
      <el-table-column label="开盘价" align="center" prop="openingPrice" />
      <el-table-column label="收盘价" align="center" prop="closingPrice" />
      <el-table-column label="创建时间" align="center" prop="createTime" width="160">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createTime) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="更新时间" align="center" prop="updateTime" width="160">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.updateTime) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:currencyControls:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:currencyControls:remove']"
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

    <!-- 添加或修改自发币控制对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="币名称" prop="tokenCur">
          <el-input v-model="form.tokenCur" placeholder="请输入币名称" />
        </el-form-item>
        <el-form-item label="起始价格" prop="startingPrice">
          <el-input v-model="form.startingPrice" placeholder="请输入起始价格" />
        </el-form-item>
        <el-form-item label="结束价格" prop="finalPrice">
          <el-input v-model="form.finalPrice" placeholder="请输入结束价格" />
        </el-form-item>
        <el-form-item label="最大交易量" prop="tradingVolumeMax">
          <el-input v-model="form.tradingVolumeMax" placeholder="请输入最大交易量" />
        </el-form-item>
        <el-form-item label="最小交易量" prop="tradingVolumeMin">
          <el-input v-model="form.tradingVolumeMin" placeholder="请输入最小交易量" />
        </el-form-item>
        <el-form-item label="状态" prop="status">
          <el-select v-model="form.status" placeholder="请选择状态">
            <el-option
              v-for="dict in dict.type.zfbkz_status"
              :key="dict.value"
              :label="dict.label"
:value="parseInt(dict.value)"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="开盘价" prop="openingPrice">
          <el-input v-model="form.openingPrice" placeholder="请输入开盘价" />
        </el-form-item>
        <el-form-item label="收盘价" prop="closingPrice">
          <el-input v-model="form.closingPrice" placeholder="请输入收盘价" />
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
import { listCurrencyControls, getCurrencyControls, delCurrencyControls, addCurrencyControls, updateCurrencyControls } from "@/api/line/currencyControls";

export default {
  name: "CurrencyControls",
  dicts: ['zfbkz_status'],
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
      // 自发币控制表格数据
      currencyControlsList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        tokenCur: null,
        startingPrice: null,
        finalPrice: null,
        tradingVolumeMax: null,
        tradingVolumeMin: null,
        status: null,
        openingPrice: null,
        closingPrice: null
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
    /** 查询自发币控制列表 */
    getList() {
      this.loading = true;
      listCurrencyControls(this.queryParams).then(response => {
        this.currencyControlsList = response.rows;
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
        tokenCur: null,
        startingPrice: null,
        finalPrice: null,
        tradingVolumeMax: null,
        tradingVolumeMin: null,
        status: null,
        createTime: null,
        updateTime: null,
        openingPrice: null,
        closingPrice: null
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
      this.title = "添加自发币控制";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getCurrencyControls(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改自发币控制";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateCurrencyControls(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addCurrencyControls(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除自发币控制编号为"' + ids + '"的数据项？').then(function() {
        return delCurrencyControls(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/currencyControls/export', {
        ...this.queryParams
      }, `currencyControls_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
