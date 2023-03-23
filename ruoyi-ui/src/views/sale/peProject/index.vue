<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="98px">
      <el-form-item label="订单编号" prop="orderIndex">
        <el-input
          v-model="queryParams.orderIndex"
          placeholder="请输入订单编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="项目名称" prop="projectName">
        <el-input
          v-model="queryParams.projectName"
          placeholder="请输入项目名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="项目地址" prop="projectUrl">
        <el-input
          v-model="queryParams.projectUrl"
          placeholder="请输入项目地址"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <!-- <el-form-item label="大图" prop="projectImg">
        <el-input
          v-model="queryParams.projectImg"
          placeholder="请输入大图"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
      <el-form-item label="私募开始时间" prop="startTime">
        <el-date-picker clearable
          v-model="queryParams.startTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择私募开始时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="私募结束时间" prop="endTime">
        <el-date-picker clearable
          v-model="queryParams.endTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择私募结束时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="已经募数量" prop="nowNum">
        <el-input
          v-model="queryParams.nowNum"
          placeholder="请输入已经募数量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="私募数" prop="sumNum">
        <el-input
          v-model="queryParams.sumNum"
          placeholder="请输入私募数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="最小数量" prop="minNum">
        <el-input
          v-model="queryParams.minNum"
          placeholder="请输入最小数量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="最大数量" prop="maxNum">
        <el-input
          v-model="queryParams.maxNum"
          placeholder="请输入最大数量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="单价" prop="coinPice">
        <el-input
          v-model="queryParams.coinPice"
          placeholder="请输入单价"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="币种名称" prop="coinName">
        <el-select v-model="queryParams.coinName" placeholder="请选择币种名称" clearable>
          <el-option
            v-for="dict in curs"
            :key="dict.id"
            :label="dict.tokenCur"
            :value="dict.tokenCur"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="私募状态" prop="status">
        <el-select v-model="queryParams.status" placeholder="请选择私募状态" clearable>
          <el-option
            v-for="dict in dict.type.pe_status"
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
          v-hasPermi="['system:peProject:add']"
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
          v-hasPermi="['system:peProject:edit']"
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
          v-hasPermi="['system:peProject:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:peProject:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="peProjectList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="ID" align="center" prop="id" />
      <el-table-column label="订单编号" align="center" prop="orderIndex" />
      <el-table-column label="项目名称" align="center" prop="projectName" />
      <el-table-column label="项目地址" align="center" prop="projectUrl" />
      <el-table-column label="大图" align="center" prop="projectImg" width="100">
        <template slot-scope="scope">
          <image-preview :src="scope.row.projectImg" :width="50" :height="50"/>
        </template>
      </el-table-column>
      <el-table-column label="私募开始时间" align="center" prop="startTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.startTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="私募结束时间" align="center" prop="endTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.endTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="已经募数量" align="center" prop="nowNum" />
      <el-table-column label="私募数" align="center" prop="sumNum" />
      <el-table-column label="最小数量" align="center" prop="minNum" />
      <el-table-column label="最大数量" align="center" prop="maxNum" />
      <el-table-column label="单价" align="center" prop="coinPice" />
      <el-table-column label="币种名称" align="center" prop="coinName">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.t_pair_type" :value="scope.row.coinName"/>
        </template>
      </el-table-column>
      <el-table-column label="私募状态" align="center" prop="status">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.pe_status" :value="scope.row.status"/>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:peProject:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:peProject:remove']"
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

    <!-- 添加或修改私募项目对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="700px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="100px">
        <el-form-item label="订单编号" prop="orderIndex">
          <el-input v-model="form.orderIndex" placeholder="请输入订单编号" />
        </el-form-item>
        <el-form-item label="项目名称" prop="projectName">
          <el-input v-model="form.projectName" placeholder="请输入项目名称" />
        </el-form-item>
        <el-form-item label="项目地址" prop="projectUrl">
          <el-input v-model="form.projectUrl" placeholder="请输入项目地址" />
        </el-form-item>
        <el-form-item label="大图" prop="projectImg">
          <image-upload v-model="form.projectImg"/>
        </el-form-item>
        <el-form-item label="私募开始时间" prop="startTime">
          <el-date-picker clearable
            v-model="form.startTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择私募开始时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="私募结束时间" prop="endTime">
          <el-date-picker clearable
            v-model="form.endTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择私募结束时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="已经募数量" prop="nowNum">
          <el-input v-model="form.nowNum" placeholder="请输入已经募数量" />
        </el-form-item>
        <el-form-item label="私募数" prop="sumNum">
          <el-input v-model="form.sumNum" placeholder="请输入私募数" />
        </el-form-item>
        <el-form-item label="最小数量" prop="minNum">
          <el-input v-model="form.minNum" placeholder="请输入最小数量" />
        </el-form-item>
        <el-form-item label="最大数量" prop="maxNum">
          <el-input v-model="form.maxNum" placeholder="请输入最大数量" />
        </el-form-item>
        <el-form-item label="单价" prop="coinPice">
          <el-input v-model="form.coinPice" placeholder="请输入单价" />
        </el-form-item>
        <el-form-item label="币种名称" prop="coinName">
          <el-select v-model="form.coinName" placeholder="请选择币种名称">
            <el-option
              v-for="dict in curs"
              :key="dict.id"
              :label="dict.tokenCur"
:value="dict.tokenCur"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="私募状态" prop="status">
          <el-select v-model="form.status" placeholder="请选择私募状态">
            <el-option
              v-for="dict in dict.type.pe_status"
              :key="dict.value"
              :label="dict.label"
:value="dict.value"
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
import { listPeProject, getPeProject, delPeProject, addPeProject, updatePeProject } from "@/api/system/peProject";
import { tokenCurList } from "@/api/system/pairs";
export default {
  name: "PeProject",
  dicts: ['t_pair_type', 'pe_status'],
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
      // 私募项目表格数据
      peProjectList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        orderIndex: null,
        projectName: null,
        projectUrl: null,
        projectImg: null,
        startTime: null,
        endTime: null,
        nowNum: null,
        sumNum: null,
        minNum: null,
        maxNum: null,
        coinPice: null,
        coinName: null,
        status: null,
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
    this.getCurs();
  },
  methods: {
    /** 查询私募项目列表 */
    getList() {
      this.loading = true;
      listPeProject(this.queryParams).then(response => {
        this.peProjectList = response.rows;
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
        orderIndex: null,
        projectName: null,
        projectUrl: null,
        projectImg: null,
        startTime: null,
        endTime: null,
        nowNum: null,
        sumNum: null,
        minNum: null,
        maxNum: null,
        coinPice: null,
        coinName: null,
        status: null,
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
      this.title = "添加私募项目";
      this.getCurs();
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      this.getCurs();
      getPeProject(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改私募项目";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updatePeProject(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addPeProject(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除私募项目编号为"' + ids + '"的数据项？').then(function() {
        return delPeProject(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/peProject/export', {
        ...this.queryParams
      }, `peProject_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
