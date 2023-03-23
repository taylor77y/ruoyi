<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="交易对名称" prop="pairsName">
        <el-input
          v-model="queryParams.pairsName"
          placeholder="请选择交易对名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <!-- <el-form-item label="合约乘数" prop="contractMul">
        <el-input
          v-model="queryParams.contractMul"
          placeholder="请输入合约乘数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="强平价格" prop="forcePrice">
        <el-input
          v-model="queryParams.forcePrice"
          placeholder="请输入强平价格"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="开仓手续费" prop="makerFee">
        <el-input
          v-model="queryParams.makerFee"
          placeholder="请输入开仓手续费"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="平仓手续费" prop="takerFee">
        <el-input
          v-model="queryParams.takerFee"
          placeholder="请输入平仓手续费"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="强平手续费" prop="forceFee">
        <el-input
          v-model="queryParams.forceFee"
          placeholder="请输入强平手续费"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="交易手续费" prop="tradeFee">
        <el-input
          v-model="queryParams.tradeFee"
          placeholder="请输入交易手续费"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="提币手续费" prop="withdrawFee">
        <el-input
          v-model="queryParams.withdrawFee"
          placeholder="请输入提币手续费"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="维持保证金比率" prop="ensure">
        <el-input
          v-model="queryParams.ensure"
          placeholder="请输入维持保证金比率"
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
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:contractMul:add']"
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
          v-hasPermi="['system:contractMul:edit']"
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
          v-hasPermi="['system:contractMul:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:contractMul:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="contractMulList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <!-- <el-table-column label="ID" align="center" prop="id" /> -->
      <el-table-column label="交易对名称" align="center" prop="pairsName"/>
      <el-table-column label="合约乘数" align="center" prop="contractMul" />
      <el-table-column label="开仓手续费" align="center" prop="makerFee" />
      <el-table-column label="平仓手续费" align="center" prop="takerFee" />
      <el-table-column label="强平价格" align="center" prop="forcePrice" />
      <el-table-column label="强平手续费" align="center" prop="forceFee" />
      <el-table-column label="交易手续费" align="center" prop="tradeFee" />
      <el-table-column label="提币手续费" align="center" prop="withdrawFee" />
      <el-table-column label="维持保证金比率" align="center" prop="ensure" />
      <el-table-column label="更新时间" align="center" prop="updateTime" width="180">
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
            v-hasPermi="['system:contractMul:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:contractMul:remove']"
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

    <!-- 添加或修改合约交易对对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="800px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="110px">
        <el-form-item label="交易对名称" prop="pairsName">
          <el-select v-model="form.pairsName" placeholder="请选择交易对名称">
            <el-option
              v-for="dict in curs"
              :key="dict.id"
              :label="dict.pairsName"
:value="dict.pairsName"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="合约乘数" prop="contractMul">
          <el-input v-model="form.contractMul" placeholder="请输入合约乘数" />
        </el-form-item>
        <el-form-item label="强平价格" prop="forcePrice">
          <el-input v-model="form.forcePrice" placeholder="请输入强平价格" />
        </el-form-item>
        <el-form-item label="开仓手续费" prop="makerFee">
          <el-input v-model="form.makerFee" placeholder="请输入开仓手续费" />
        </el-form-item>
        <el-form-item label="平仓手续费" prop="takerFee">
          <el-input v-model="form.takerFee" placeholder="请输入平仓手续费" />
        </el-form-item>
        <el-form-item label="强平手续费" prop="forceFee">
          <el-input v-model="form.forceFee" placeholder="请输入强平手续费" />
        </el-form-item>
        <el-form-item label="交易手续费" prop="tradeFee">
          <el-input v-model="form.tradeFee" placeholder="请输入交易手续费" />
        </el-form-item>
        <el-form-item label="提币手续费" prop="withdrawFee">
          <el-input v-model="form.withdrawFee" placeholder="请输入提币手续费" />
        </el-form-item>
        <el-form-item label="维持保证金比率" prop="ensure">
          <el-input v-model="form.ensure" placeholder="请输入维持保证金比率" />
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
import { listContractMul, getContractMul, delContractMul, addContractMul, updateContractMul } from "@/api/system/contractMul";
import { tokenCurList } from "@/api/system/pairs";
export default {
  name: "ContractMul",
  dicts: ['otc_fx'],
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
      // 合约交易对表格数据
      contractMulList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        pairsName: null,
        contractMul: null,
        forcePrice: null,
        makerFee: null,
        takerFee: null,
        forceFee: null,
        tradeFee: null,
        withdrawFee: null,
        ensure: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      },
      curs:[]
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询合约交易对列表 */
    getList() {
      this.loading = true;
      listContractMul(this.queryParams).then(response => {
        this.contractMulList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    getCurs(){
      tokenCurList().then(res=>{
        console.log(res)
        this.curs = res.data
      })
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
        contractMul: null,
        forcePrice: null,
        makerFee: null,
        takerFee: null,
        forceFee: null,
        tradeFee: null,
        withdrawFee: null,
        ensure: null,
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
      this.title = "添加合约交易对";
      this.getCurs();
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      this.getCurs();
      getContractMul(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改合约交易对";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateContractMul(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addContractMul(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除合约交易对编号为"' + ids + '"的数据项？').then(function() {
        return delContractMul(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/contractMul/export', {
        ...this.queryParams
      }, `contractMul_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
