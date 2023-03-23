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
      <el-form-item label="时间类型" prop="timeType">
        <el-select v-model="queryParams.timeType" placeholder="请选择时间类型" clearable>
          <el-option
            v-for="dict in dict.type.zfb_tm_scn"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="最高价" prop="high">
        <el-input
          v-model="queryParams.high"
          placeholder="请输入最高价"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="最低价" prop="low">
        <el-input
          v-model="queryParams.low"
          placeholder="请输入最低价"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="成交量" prop="volume">
        <el-input
          v-model="queryParams.volume"
          placeholder="请输入成交量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="成交额" prop="vol">
        <el-input
          v-model="queryParams.vol"
          placeholder="请输入成交额"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="成交笔数" prop="count">
        <el-input
          v-model="queryParams.count"
          placeholder="请输入成交笔数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="开盘价" prop="open">
        <el-input
          v-model="queryParams.open"
          placeholder="请输入开盘价"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="收盘价" prop="close">
        <el-input
          v-model="queryParams.close"
          placeholder="请输入收盘价"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="状态" prop="status">
        <el-select v-model="queryParams.status" placeholder="请选择状态" clearable>
          <el-option
            v-for="dict in dict.type.zfb_ts_price_status"
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
          v-hasPermi="['system:stagePrice:add']"
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
          v-hasPermi="['system:stagePrice:edit']"
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
          v-hasPermi="['system:stagePrice:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:stagePrice:export']"
        >导出</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="multiple"
          @click="handleBatchUp"
          v-hasPermi="['system:stagePrice:batch']"
        >条件批量修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-edit"
          size="mini"
          @click="handleBatchUp2"
          v-hasPermi="['system:stagePrice:batch']"
        >时间批量修改</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="stagePriceList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="ID" align="center" prop="id" />
      <el-table-column label="币名称" align="center" prop="tokenCur" />
      <el-table-column label="时间类型" align="center" prop="timeType" />
      <el-table-column label="最高价" align="center" prop="high" />
      <el-table-column label="最低价" align="center" prop="low" />
      <el-table-column label="成交量" align="center" prop="volume" />
      <el-table-column label="成交额" align="center" prop="vol" />
      <el-table-column label="成交笔数" align="center" prop="count" />
      <el-table-column label="开盘价" align="center" prop="open" />
      <el-table-column label="收盘价" align="center" prop="close" />
      <el-table-column label="创建时间" align="center" prop="createTime" width="160">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createTime) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="状态" align="center" prop="status">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.zfb_ts_price_status" :value="scope.row.status"/>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:stagePrice:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:stagePrice:remove']"
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

    <!-- 添加或修改自发币时间阶段价格对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="币名称" prop="tokenCur">
          <el-input v-model="form.tokenCur" placeholder="请输入币名称" />
        </el-form-item>
        <el-form-item label="最高价" prop="high">
          <el-input v-model="form.high" placeholder="请输入最高价" />
        </el-form-item>
        <el-form-item label="最低价" prop="low">
          <el-input v-model="form.low" placeholder="请输入最低价" />
        </el-form-item>
        <el-form-item label="成交量" prop="volume">
          <el-input v-model="form.volume" placeholder="请输入成交量" />
        </el-form-item>
        <el-form-item label="成交额" prop="vol">
          <el-input v-model="form.vol" placeholder="请输入成交额" />
        </el-form-item>
        <el-form-item label="成交笔数" prop="count">
          <el-input v-model="form.count" placeholder="请输入成交笔数" />
        </el-form-item>
        <el-form-item label="开盘价" prop="open">
          <el-input v-model="form.open" placeholder="请输入开盘价" />
        </el-form-item>
        <el-form-item label="收盘价" prop="close">
          <el-input v-model="form.close" placeholder="请输入收盘价" />
        </el-form-item>
        <el-form-item label="状态">
          <el-radio-group v-model="form.status">
            <el-radio
              v-for="dict in dict.type.zfb_ts_price_status"
              :key="dict.value"
:label="parseInt(dict.value)"
            >{{dict.label}}</el-radio>
          </el-radio-group>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>

     <!-- 条件批量修改 -->
    <el-dialog title="条件批量修改" :visible.sync="batchOpen" width="500px" append-to-body>
      <el-form ref="batchForm" :model="batchForm" :rules="batchRules" label-width="80px">
        <el-form-item label="币种" prop="name">
          <el-select v-model="batchForm.name" placeholder="请选择币种">
            <el-option
              v-for="dict in zfbList"
              :key="dict.id"
              :label="dict.tokenCur"
              :value="dict.tokenCur"
            />
          </el-select>
        </el-form-item>
        <el-form-item label="修改类型" prop="type">
          <el-select v-model="batchForm.type" placeholder="请选择修改类型">
            <el-option
              v-for="dict in dict.type.zfb_time_tyoes"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            />
          </el-select>
        </el-form-item>
        <el-form-item label="设置价格" prop="val">
          <el-input v-model="batchForm.val" placeholder="请输入价格" />
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="batchSubmitForm('batchForm')">确定</el-button>
          <el-button @click="batchResetForm('batchForm')">取消</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>

     <!-- 时间批量修改 -->
    <el-dialog title="时间批量修改" :visible.sync="batchOpen2" width="500px" append-to-body>
      <el-form ref="batchForm2" :model="batchForm2" :rules="batchRules2" label-width="80px">
        <el-form-item label="币种" prop="name">
          <el-select v-model="batchForm2.name" placeholder="请选择币种">
            <el-option
              v-for="dict in zfbList"
              :key="dict.id"
              :label="dict.tokenCur"
              :value="dict.tokenCur"
            />
          </el-select>
        </el-form-item>
        <el-form-item label="修改类型" prop="type">
          <el-select v-model="batchForm2.type" placeholder="请选择修改类型">
            <el-option
              v-for="dict in dict.type.zfb_time_tyoes"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            />
          </el-select>
        </el-form-item>
        <el-form-item label="时间筛选" prop="time">
          <el-select v-model="batchForm2.time" placeholder="请选择时间">
            <el-option
              v-for="dict in dict.type.zfb_tm_scn"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            />
          </el-select>
        </el-form-item>
        <el-form-item label="设置价格" prop="val">
          <el-input v-model="batchForm2.val" placeholder="请输入价格" />
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="batchSubmitForm2('batchForm2')">确定</el-button>
          <el-button @click="batchResetForm2('batchForm2')">取消</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
  </div>
</template>

<script>
import { listStagePrice, getStagePrice, delStagePrice, addStagePrice, batchStagePrice } from "@/api/line/stagePrice";
import { getCurs } from "@/api/line/currencyControls";
export default {
  name: "StagePrice",
  dicts: ['zfb_ts_price_status','zfb_time_tyoes','zfb_tm_scn'],
  data() {
    return {
      zfbList:[],
      batchOpen:false,
      batchForm:{
        name:null,
        type:null,
        val:null,
        mode:1
      },
      batchRules:{
        name: [
          { required: true, message: '请选择币种', trigger: 'change' }
        ],
        type: [
          { required: true, message: '请选择修改类型', trigger: 'change' }
        ],
        val: [
          { required: true, message: '请输入价格', trigger: 'change' }
        ],
      },
      batchOpen2:false,
      batchForm2:{
        name:null,
        type:null,
        val:null,
        time:null,
        mode:2,
      },
      batchRules2:{
        name: [
          { required: true, message: '请选择币种', trigger: 'change' }
        ],
        type: [
          { required: true, message: '请选择修改类型', trigger: 'change' }
        ],
        val: [
          { required: true, message: '请输入价格', trigger: 'change' }
        ],
        time: [
          { required: true, message: '请选择时间', trigger: 'change' }
        ],
      },
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
      // 自发币时间阶段价格表格数据
      stagePriceList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        tokenCur: null,
        timeType: null,
        high: null,
        low: null,
        volume: null,
        vol: null,
        count: null,
        open: null,
        close: null,
        status: null,
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
    getZFBList(){
      getCurs().then(res=>{
        this.zfbList = res.data;
      })
    },
    batchSubmitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          let data = Object.assign(this.batchForm,{list:this.ids});
          batchStagePrice(data).then(res=>{
            this.getList();
            this.ids = []
            this.batchOpen = false;
            this.$refs[formName].resetFields();
          })
        } 
      });
    },
    batchResetForm(formName) {
      this.batchOpen = false;
      this.$refs[formName].resetFields();
    },
    //批量修改
    handleBatchUp(){
      this.batchOpen = true;
      this.getZFBList();
    },


    batchSubmitForm2(formName2) {
      this.$refs[formName2].validate((valid) => {
        if (valid) {
          batchStagePrice(this.batchForm2).then(res=>{
            console.log("请求结果",res)
            this.getList();
            this.batchOpen2 = false;
            this.$refs[formName2].resetFields();
          })
        } 
      });
    },
    batchResetForm2(formName2) {
      this.batchOpen2 = false;
      this.$refs[formName2].resetFields();
    },
    //批量修改
    handleBatchUp2(){
      this.batchOpen2 = true;
      this.getZFBList();
    },
    /** 查询自发币时间阶段价格列表 */
    getList() {
      this.loading = true;
      listStagePrice(this.queryParams).then(response => {
        this.stagePriceList = response.rows;
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
        timeType: null,
        high: null,
        low: null,
        volume: null,
        vol: null,
        count: null,
        open: null,
        close: null,
        status: 0,
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
      this.title = "添加自发币时间阶段价格";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getStagePrice(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改自发币时间阶段价格";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateStagePrice(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addStagePrice(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除自发币时间阶段价格编号为"' + ids + '"的数据项？').then(function() {
        return delStagePrice(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/stagePrice/export', {
        ...this.queryParams
      }, `stagePrice_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
