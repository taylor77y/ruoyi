<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="倍数" prop="lever">
        <el-input
          v-model="queryParams.lever"
          placeholder="请输入倍数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="倍数描述" prop="leverDesc">
        <el-input
          v-model="queryParams.leverDesc"
          placeholder="请输入倍数描述"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="交易对" prop="pairsName">
        <el-input
          v-model="queryParams.pairsName"
          placeholder="请选择交易对"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <!-- <el-form-item label="手" prop="handsMax">
        <el-input
          v-model="queryParams.handsMax"
          placeholder="请输入手"
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
          v-hasPermi="['system:lever:add']"
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
          v-hasPermi="['system:lever:edit']"
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
          v-hasPermi="['system:lever:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:lever:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="leverList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <!-- <el-table-column label="ID" align="center" prop="id" /> -->
      <el-table-column label="倍数" align="center" prop="lever" />
      <el-table-column label="倍数描述" align="center" prop="leverDesc" />
      <el-table-column label="交易对" align="center" prop="pairsName"/>
      <el-table-column label="手" align="center" prop="handsMax" />
      <el-table-column label="创建时间" align="center" prop="createTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createTime) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:lever:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:lever:remove']"
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

    <!-- 添加或修改合约杠杆对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="倍数" prop="lever">
          <el-input v-model="form.lever" placeholder="请输入倍数" />
        </el-form-item>
        <el-form-item label="倍数描述" prop="leverDesc">
          <el-input v-model="form.leverDesc" placeholder="请输入倍数描述" />
        </el-form-item>
        <el-form-item label="交易对" prop="pairsName">
          <el-select v-model="form.pairsName" placeholder="请选择交易对">
            <el-option
              v-for="dict in curs"
              :key="dict.id"
              :label="dict.pairsName"
:value="dict.pairsName"
            ></el-option>
          </el-select>
        </el-form-item>
        <!-- <el-form-item label="手" prop="handsMax">
          <el-input v-model="form.handsMax" placeholder="请输入手" />
        </el-form-item> -->
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listLever, getLever, delLever, addLever, updateLever } from "@/api/system/lever";
import { tokenCurList } from "@/api/system/pairs";
export default {
  name: "Lever",
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
      // 合约杠杆表格数据
      leverList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        lever: null,
        leverDesc: null,
        pairsName: null,
        handsMax: null,
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
    /** 查询合约杠杆列表 */
    getList() {
      this.loading = true;
      listLever(this.queryParams).then(response => {
        this.leverList = response.rows;
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
        lever: null,
        leverDesc: null,
        pairsName: null,
        handsMax: null,
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
      this.title = "添加合约杠杆";
      this.getCurs();
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      this.getCurs();
      getLever(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改合约杠杆";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateLever(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addLever(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除合约杠杆编号为"' + ids + '"的数据项？').then(function() {
        return delLever(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/lever/export', {
        ...this.queryParams
      }, `lever_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
