<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="128px">
      <el-form-item label="交易对名称" prop="pairName">
        <el-input
          v-model="queryParams.pairName"
          placeholder="请输入交易对名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是否开启k线" prop="openKine">
        <el-select v-model="queryParams.openKine" placeholder="请选择是否开启k线" clearable>
          <el-option
            v-for="dict in dict.type.open_close"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="是否开启" prop="isOpen">
        <el-select v-model="queryParams.isOpen" placeholder="请选择是否开启" clearable>
          <el-option
            v-for="dict in dict.type.open_close"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="是否开启盘口" prop="openTape">
        <el-select v-model="queryParams.openTape" placeholder="请选择是否开启盘口" clearable>
          <el-option
            v-for="dict in dict.type.open_close"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="目标价格" prop="willPrice">
        <el-input
          v-model="queryParams.willPrice"
          placeholder="请输入目标价格"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="目标时间" prop="willTime">
        <el-date-picker clearable
          v-model="queryParams.willTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择目标时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="绑定用户" prop="bindUser">
        <el-input
          v-model="queryParams.bindUser"
          placeholder="请输入绑定用户"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="下单数量上限" prop="startNum">
        <el-input
          v-model="queryParams.startNum"
          placeholder="请输入下单数量上限"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="下单数量波动下限" prop="endNum">
        <el-input
          v-model="queryParams.endNum"
          placeholder="请输入下单数量波动下限"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="下单价格波动上限" prop="startPrice">
        <el-input
          v-model="queryParams.startPrice"
          placeholder="请输入下单价格波动上限"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="下单价格波动上限" prop="endPrice">
        <el-input
          v-model="queryParams.endPrice"
          placeholder="请输入下单价格波动上限"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="撮合数量波动上限" prop="mendNum">
        <el-input
          v-model="queryParams.mendNum"
          placeholder="请输入撮合数量波动上限"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="撮合数量波动下限" prop="mstartNum">
        <el-input
          v-model="queryParams.mstartNum"
          placeholder="请输入撮合数量波动下限"
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
          v-hasPermi="['system:robotConfig:add']"
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
          v-hasPermi="['system:robotConfig:edit']"
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
          v-hasPermi="['system:robotConfig:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:robotConfig:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="robotConfigList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="ID" align="center" prop="id" />
      <el-table-column label="交易对名称" align="center" prop="pairName" />
      <el-table-column label="是否开启k线" align="center" prop="openKine">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.open_close" :value="scope.row.openKine"/>
        </template>
      </el-table-column>
      <el-table-column label="是否开启" align="center" prop="isOpen">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.open_close" :value="scope.row.isOpen"/>
        </template>
      </el-table-column>
      <el-table-column label="是否开启盘口" align="center" prop="openTape">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.open_close" :value="scope.row.openTape"/>
        </template>
      </el-table-column>
      <el-table-column label="目标价格" align="center" prop="willPrice" />
      <el-table-column label="目标时间" align="center" prop="willTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.willTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="绑定用户" align="center" prop="bindUser" />
      <el-table-column label="下单数量上限" align="center" prop="startNum" />
      <el-table-column label="下单数量波动下限" align="center" prop="endNum" />
      <el-table-column label="下单价格波动上限" align="center" prop="startPrice" />
      <el-table-column label="下单价格波动上限" align="center" prop="endPrice" />
      <el-table-column label="撮合数量波动上限" align="center" prop="mendNum" />
      <el-table-column label="撮合数量波动下限" align="center" prop="mstartNum" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:robotConfig:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:robotConfig:remove']"
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

    <!-- 添加或修改机器人配置对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="800px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="130px">
        <el-form-item label="交易对名称" prop="pairName">
          <el-input v-model="form.pairName" placeholder="请输入交易对名称" />
        </el-form-item>
        <el-form-item label="是否开启k线" prop="openKine">
          <el-select v-model="form.openKine" placeholder="请选择是否开启k线">
            <el-option
              v-for="dict in dict.type.open_close"
              :key="dict.value"
              :label="dict.label"
:value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="是否开启" prop="isOpen">
          <el-select v-model="form.isOpen" placeholder="请选择是否开启">
            <el-option
              v-for="dict in dict.type.open_close"
              :key="dict.value"
              :label="dict.label"
:value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="是否开启盘口" prop="openTape">
          <el-select v-model="form.openTape" placeholder="请选择是否开启盘口">
            <el-option
              v-for="dict in dict.type.open_close"
              :key="dict.value"
              :label="dict.label"
:value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="目标价格" prop="willPrice">
          <el-input v-model="form.willPrice" placeholder="请输入目标价格" />
        </el-form-item>
        <el-form-item label="目标时间" prop="willTime">
          <el-date-picker clearable
            v-model="form.willTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择目标时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="绑定用户" prop="bindUser">
          <el-input v-model="form.bindUser" placeholder="请输入绑定用户" />
        </el-form-item>
        <el-form-item label="下单数量上限" prop="startNum">
          <el-input v-model="form.startNum" placeholder="请输入下单数量上限" />
        </el-form-item>
        <el-form-item label="下单数量波动下限" prop="endNum">
          <el-input v-model="form.endNum" placeholder="请输入下单数量波动下限" />
        </el-form-item>
        <el-form-item label="下单价格波动上限" prop="startPrice">
          <el-input v-model="form.startPrice" placeholder="请输入下单价格波动上限" />
        </el-form-item>
        <el-form-item label="下单价格波动上限" prop="endPrice">
          <el-input v-model="form.endPrice" placeholder="请输入下单价格波动上限" />
        </el-form-item>
        <el-form-item label="撮合数量波动上限" prop="mendNum">
          <el-input v-model="form.mendNum" placeholder="请输入撮合数量波动上限" />
        </el-form-item>
        <el-form-item label="撮合数量波动下限" prop="mstartNum">
          <el-input v-model="form.mstartNum" placeholder="请输入撮合数量波动下限" />
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
import { listRobotConfig, getRobotConfig, delRobotConfig, addRobotConfig, updateRobotConfig } from "@/api/system/robotConfig";

export default {
  name: "RobotConfig",
  dicts: ['open_close'],
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
      // 机器人配置表格数据
      robotConfigList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        pairName: null,
        openKine: null,
        isOpen: null,
        openTape: null,
        willPrice: null,
        willTime: null,
        bindUser: null,
        startNum: null,
        endNum: null,
        startPrice: null,
        endPrice: null,
        mendNum: null,
        mstartNum: null,
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
    /** 查询机器人配置列表 */
    getList() {
      this.loading = true;
      listRobotConfig(this.queryParams).then(response => {
        this.robotConfigList = response.rows;
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
        pairName: null,
        openKine: null,
        isOpen: null,
        openTape: null,
        willPrice: null,
        willTime: null,
        bindUser: null,
        startNum: null,
        endNum: null,
        startPrice: null,
        endPrice: null,
        mendNum: null,
        mstartNum: null,
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
      this.title = "添加机器人配置";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getRobotConfig(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改机器人配置";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateRobotConfig(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addRobotConfig(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除机器人配置编号为"' + ids + '"的数据项？').then(function() {
        return delRobotConfig(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/robotConfig/export', {
        ...this.queryParams
      }, `robotConfig_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
