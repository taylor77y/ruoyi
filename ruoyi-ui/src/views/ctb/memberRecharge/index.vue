<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="108px">
      <el-form-item label="上级会员手机号" prop="lastPhone">
        <el-input
          v-model="queryParams.lastPhone"
          placeholder="请输入上级会员手机号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="会员UUID" prop="uuid">
        <el-input
          v-model="queryParams.uuid"
          placeholder="请输入会员UUUID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="会员手机号" prop="phone">
        <el-input
          v-model="queryParams.phone"
          placeholder="请输入会员手机号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="充值状态" prop="status">
        <el-select v-model="queryParams.status" placeholder="请选择充值状态" clearable>
          <el-option
            v-for="dict in dict.type.rec_status"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <!-- <el-form-item label="币种" prop="currency">
        <el-input
          v-model="queryParams.currency"
          placeholder="请输入币种"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="充值金额" prop="amount">
        <el-input
          v-model="queryParams.amount"
          placeholder="请输入充值金额"
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
          v-hasPermi="['system:memberRecharge:add']"
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
          v-hasPermi="['system:memberRecharge:edit']"
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
          v-hasPermi="['system:memberRecharge:remove']"
        >删除</el-button>
      </el-col> -->
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:memberRecharge:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="memberRechargeList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <!-- <el-table-column label="ID" align="center" prop="id" /> -->
      <el-table-column label="上级会员手机号" align="center" prop="lastPhone" />
      <el-table-column label="会员UUID" align="center" prop="uuid" />
      <el-table-column label="会员手机号" align="center" prop="phone" />
       <el-table-column label="账号类型" align="center" prop="useType" width="100">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.member_zh_type" :value="scope.row.useType"/>
        </template>
      </el-table-column>
      <el-table-column label="币种" align="center" prop="currency" />
      <el-table-column label="充值金额" align="center" prop="amount">
        <template slot-scope="scope">
          <el-tag type="danger">{{scope.row.amount}}</el-tag>
        </template>
      </el-table-column>
      <el-table-column label="充值凭证" align="center" prop="paymentVoucher" width="100">
        <template slot-scope="scope">
          <image-preview :src="scope.row.paymentVoucher" :width="50" :height="50"/>
        </template>
      </el-table-column>
      <el-table-column label="充值状态" align="center" prop="status">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.rec_status" :value="scope.row.status"/>
        </template>
      </el-table-column>
      <el-table-column label="审核信息" align="center" prop="remark" />
      <el-table-column label="链名" align="center" prop="chainName" />
      <el-table-column label="创建时间" align="center" prop="createTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createTime) }}</span>
        </template>
      </el-table-column>
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
            v-if="scope.row.status === 1"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:memberRecharge:edit']"
          >修改金额</el-button>
          <!-- <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:memberRecharge:remove']"
          >删除</el-button> -->
          <el-button
            size="mini"
            type="text"
            icon="el-icon-view"
            v-if="scope.row.status === 1"
            @click="handleAgree(scope.row)"
            v-hasPermi="['system:memberRecharge:agree']"
          >同意</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-view"
            v-if="scope.row.status === 1"
            @click="handleReject(scope.row)"
            v-hasPermi="['system:memberRecharge:reject']"
          >驳回</el-button>
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

    <!-- 添加或修改会员充值对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="会员ID" prop="memberId">
          <el-input v-model="form.memberId" disabled placeholder="请输入会员ID" />
        </el-form-item>
        <!-- <el-form-item label="币种" prop="currency">
          <el-input v-model="form.currency" placeholder="请输入币种" />
        </el-form-item> -->
        <el-form-item label="金额" prop="amount">
          <el-input v-model="form.amount" placeholder="请输入金额" />
        </el-form-item>
        <!-- <el-form-item label="充值状态" prop="status">
          <el-select v-model="form.status" placeholder="请选择充值状态">
            <el-option
              v-for="dict in dict.type.rec_status"
              :key="dict.value"
              :label="dict.label"
:value="parseInt(dict.value)"
            ></el-option>
          </el-select>
        </el-form-item> -->
        <!-- <el-form-item label="审核信息" prop="remark">
          <el-input v-model="form.remark" placeholder="请输入审核信息" />
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
import { listMemberRecharge, getMemberRecharge, delMemberRecharge, addMemberRecharge, updateMemberRecharge,Agree,Reject } from "@/api/system/memberRecharge";
import { checkOperPwd} from "@/api/census";
export default {
  name: "MemberRecharge",
  dicts: ['rec_status','member_zh_type'],
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
      // 会员充值表格数据
      memberRechargeList: [],
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
        amount: null,
        status: null,
        phone:null,
        uuid:null,
        lastPhone:null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        status: [
          { required: true, message: "充值状态不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询会员充值列表 */
    getList() {
      this.loading = true;
      listMemberRecharge(this.queryParams).then(response => {
        this.memberRechargeList = response.rows;
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
        amount: null,
        status: 0,
        remark: null,
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
      this.title = "添加会员充值";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
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
            this.reset();
            const id = row.id || this.ids
            getMemberRecharge(id).then(response => {
              this.form = response.data;
              this.open = true;
              this.title = "修改会员充值金额";
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
            updateMemberRecharge(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addMemberRecharge(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除会员充值编号为"' + ids + '"的数据项？').then(function() {
        return delMemberRecharge(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/memberRecharge/export', {
        ...this.queryParams
      }, `memberRecharge_${new Date().getTime()}.xlsx`)
    },
    //通过
    handleAgree(row){
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
            this.$modal.confirm('确定通过此充值审核吗？').then(function() {
              return Agree(row.id);
            }).then(() => {
              this.getList();
              this.$modal.msgSuccess("成功通过");
            }).catch(() => {});
          }
        })
      }).catch(() => {});
      
    },
    //驳回
    handleReject(row){
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
            this.$modal.confirm('确定驳回此充值审核吗？').then(function() {
              return Reject(row.id);
            }).then(() => {
              this.getList();
              this.$modal.msgSuccess("成功驳回");
            }).catch(() => {});
          }
        })
      }).catch(() => {});
      
    }
  }
};
</script>
