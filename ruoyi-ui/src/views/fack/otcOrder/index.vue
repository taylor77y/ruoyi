<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <!-- <el-form-item label="用户" prop="member">
        <el-input
          v-model="queryParams.member"
          placeholder="请输入用户"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="商家昵称" prop="memberFbName">
        <el-input
          v-model="queryParams.memberFbName"
          placeholder="请输入商家昵称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
      <el-form-item label="用户手机" prop="phone">
        <el-input
          v-model="queryParams.phone"
          placeholder="请输入用户手机"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="用户邮箱" prop="mail">
        <el-input
          v-model="queryParams.mail"
          placeholder="请输入用户邮箱"
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
      <!-- <el-form-item label="剩余数量" prop="num">
        <el-input
          v-model="queryParams.num"
          placeholder="请输入剩余数量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="溢价" prop="upDownNumber">
        <el-input
          v-model="queryParams.upDownNumber"
          placeholder="请输入溢价"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="最小成交价格" prop="minPrice">
        <el-input
          v-model="queryParams.minPrice"
          placeholder="请输入最小成交价格"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="极端价格" prop="extremum">
        <el-input
          v-model="queryParams.extremum"
          placeholder="请输入极端价格"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="交易说明" prop="remarks">
        <el-input
          v-model="queryParams.remarks"
          placeholder="请输入交易说明"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
      <el-form-item label="方向" prop="direction">
        <el-select v-model="queryParams.direction" placeholder="请选择方向" clearable>
          <el-option
            v-for="dict in dict.type.otc_fx"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="收款方式" prop="payType">
        <el-select v-model="queryParams.payType" placeholder="请选择收款方式" clearable>
          <el-option
            v-for="dict in dict.type.otc_pay_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="订单状态" prop="status">
        <el-select v-model="queryParams.status" placeholder="请选择订单状态" clearable>
          <el-option
            v-for="dict in dict.type.otc_order_status"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <!-- <el-form-item label="${comment}" prop="autoMsg">
        <el-input
          v-model="queryParams.autoMsg"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="冻结数量" prop="freeze">
        <el-input
          v-model="queryParams.freeze"
          placeholder="请输入冻结数量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="已成交数量" prop="dealNum">
        <el-input
          v-model="queryParams.dealNum"
          placeholder="请输入已成交数量"
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
          v-hasPermi="['system:otcOrder:add']"
        >新增</el-button>
      </el-col>
      <!-- <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:otcOrder:edit']"
        >修改</el-button>
      </el-col> -->
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:otcOrder:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:otcOrder:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="otcOrderList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <!-- <el-table-column label="ID" align="center" prop="id" /> -->
      <el-table-column label="用户手机" align="center" prop="phone" />
      <el-table-column label="用户邮箱" align="center" prop="mail" />
      <el-table-column label="商家昵称" align="center" prop="memberFbName" />
      <el-table-column label="货币" align="center" prop="mccName" />
      <el-table-column label="币种" align="center" prop="currency" />
      <el-table-column label="剩余数量" align="center" prop="num" />
      <el-table-column label="溢价" align="center" prop="upDownNumber" />
      <el-table-column label="最小成交价格" align="center" prop="minPrice" />
      <el-table-column label="极端价格" align="center" prop="extremum" />
      <!-- <el-table-column label="交易说明" align="center" prop="remarks" /> -->
      <el-table-column label="用户买卖" align="center" prop="direction">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.otc_fx" :value="scope.row.direction"/>
        </template>
      </el-table-column>
      <el-table-column label="收款方式" align="center" prop="payType">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.otc_pay_type" :value="scope.row.payType"/>
        </template>
      </el-table-column>
      <el-table-column label="订单状态" align="center" prop="status">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.otc_order_status" :value="scope.row.status"/>
        </template>
      </el-table-column>
      <el-table-column label="冻结数量" align="center" prop="freeze" />
      <el-table-column label="已成交数量" align="center" prop="dealNum" />
      <el-table-column label="下单时间" align="center" prop="createTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createTime) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" fixed="right" width="140" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            v-if="scope.row.status == 'NORMAL'"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:otcOrder:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            v-if="scope.row.status == 'NORMAL'"
            @click="handleRevoke(scope.row)"
            v-hasPermi="['system:otcOrder:revoke']"
          >撤销</el-button>
          <!-- <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:otcOrder:remove']"
          >删除</el-button> -->
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

    <!-- 添加或修改法币订单对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="800px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="120px">
        <el-form-item label="商户" prop="member">
          <el-select v-model="form.member" v-if="form.isUp != 1" placeholder="请输入用户">
            <el-option
              v-for="dict in storeList"
              :key="dict.id"
              :label="dict.storeName"
:value="dict.id"
            ></el-option>
          </el-select>
          <el-select v-model="form.member" v-if="form.isUp == 1" disabled placeholder="请输入用户">
            <el-option
              v-for="dict in storeList"
              :key="dict.id"
              :label="dict.storeName"
:value="dict.id"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="用户买卖" prop="direction">
          <el-select v-model="form.direction" v-if="form.isUp == 1" disabled  placeholder="请选择用户买卖">
            <el-option
              v-for="dict in dict.type.otc_fx"
              :key="dict.value"
              :label="dict.label"
:value="dict.value"
            ></el-option>
          </el-select>
          <el-select v-model="form.direction" v-if="form.isUp != 1"  placeholder="请选择用户买卖">
            <el-option
              v-for="dict in dict.type.otc_fx"
              :key="dict.value"
              :label="dict.label"
:value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="支付货币" prop="mccId">
          <el-select v-model="form.mccId" placeholder="请选择支付货币" @change="setXsAmount">
            <el-option
              v-for="dict in fbList"
              :key="dict.id"
              :label="dict.currencyName"
:value="dict.id"
            ></el-option>
          </el-select>
        </el-form-item>
        <!-- <el-form-item label="商家昵称" prop="memberFbName">
          <el-input v-model="form.memberFbName" placeholder="请输入商家昵称" />
        </el-form-item> -->
        <el-form-item label="币种" prop="currency">
          <el-input v-model="form.currency" disabled placeholder="请输入币种" />
        </el-form-item>
        <el-form-item label="可接受最低价" prop="extremum">
          <el-input v-model="form.extremum" placeholder="请输入可接受最低价" />
        </el-form-item>
        <el-form-item label="数量" prop="num">
          <el-input v-model="form.num" placeholder="请输入数量" @input="setInput"/>
        </el-form-item>
        <el-form-item label="购买金额" prop="minPrice">
          <div class="inp">
            <el-input v-model="form.minPrice" placeholder="购买金额" />
            <i class="el-icon-minus"></i>
            <el-input v-model="xsAmount" disabled placeholder="最高成交额" />
          </div>
        </el-form-item>
        <el-form-item label="交易说明" prop="remarks">
          <el-input v-model="form.remarks" type="textarea" placeholder="请输入交易说明" />
        </el-form-item>
        <el-form-item label="自动回复" prop="autoStatus">
          <el-select v-model="form.autoStatus" placeholder="请选择自动回复">
            <el-option
              v-for="dict in dict.type.otc_ggh_status"
              :key="dict.value"
              :label="dict.label"
:value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="回复内容" prop="autoMsg ">
          <el-input v-model="form.autoMsg" type="textarea" placeholder="请输入回复内容" />
        </el-form-item>
        <!-- <el-form-item label="收款方式" prop="payType">
          <el-select v-model="form.payType" placeholder="请选择收款方式">
            <el-option
              v-for="dict in dict.type.otc_pay_type"
              :key="dict.value"
              :label="dict.label"
:value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item> -->
        <!-- <el-form-item label="订单状态" prop="status">
          <el-select v-model="form.status" placeholder="请选择订单状态">
            <el-option
              v-for="dict in dict.type.otc_order_status"
              :key="dict.value"
              :label="dict.label"
:value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item> -->
        <!-- <el-form-item label="${comment}" prop="autoMsg">
          <el-input v-model="form.autoMsg" placeholder="请输入${comment}" />
        </el-form-item> -->
        <!-- <el-form-item label="冻结数量" prop="freeze">
          <el-input v-model="form.freeze" placeholder="请输入冻结数量" />
        </el-form-item>
        <el-form-item label="已成交数量" prop="dealNum">
          <el-input v-model="form.dealNum" placeholder="请输入已成交数量" />
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
import { listOtcOrder, getOtcOrder, delOtcOrder, addOtcOrder, updateOtcOrder,getStoreList,getFbList,Revoke } from "@/api/system/otcOrder";

export default {
  name: "OtcOrder",
  dicts: ['otc_pay_type', 'otc_order_status', 'otc_fx','otc_ggh_status'],
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
      // 法币订单表格数据
      otcOrderList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        member: null,
        memberFbName: null,
        currency: null,
        num: null,
        upDownNumber: null,
        minPrice: null,
        extremum: null,
        remarks: null,
        direction: null,
        payType: null,
        status: null,
        autoStatus: null,
        autoMsg: null,
        freeze: null,
        dealNum: null,
        phone:null,
        mail:null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        member: [
          { required: true, message: "商户不能为空", trigger: "blur" }
        ],
        currency: [
          { required: true, message: "币种不能为空", trigger: "blur" }
        ],
        upDownNumber: [
          { required: true, message: "溢价不能为空", trigger: "blur" }
        ],
        direction: [
          { required: true, message: "用户买卖不能为空", trigger: "change" }
        ],
        mccId: [
          { required: true, message: "支付货币不能为空", trigger: "change" }
        ],
        extremum: [
          { required: true, message: "可接受最低价不能为空", trigger: "change" }
        ],
        num: [
          { required: true, message: "数量不能为空", trigger: "change" }
        ],
        minPrice: [
          { required: true, message: "购买金额不能为空", trigger: "change" }
        ],
        autoStatus: [
          { required: true, message: "自动回复不能为空", trigger: "change" }
        ],
        payType: [
          { required: true, message: "收款方式不能为空", trigger: "change" }
        ],
      },
      storeList:[],
      xsAmount:null,
      rate:null,
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询法币订单列表 */
    getList() {
      this.loading = true;
      listOtcOrder(this.queryParams).then(response => {
        this.otcOrderList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    getStoreList(){
      getStoreList().then(res=>{
        this.storeList = res.data;
      })
    },
    getFbList(){
      getFbList().then(res=>{
        this.fbList = res.data;
      })
    },
    setXsAmount(e){
      this.fbList.forEach(item => {
        if(item.id === e){
          if(this.form.num == null || this.form.num == ''){
            this.rate = item.rate;
          }else{
            this.xsAmount = this.form.num * item.rate;
          }
        }
      });
    },
    setInput(e){
      console.log(e);
      if(this.form.mccId == '' || this.form.mccId == null){
        this.xsAmount = e;
      }else{
        this.xsAmount = e*this.rate
      }
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
        member: null,
        memberFbName: null,
        currency: "USDT",
        num: null,
        upDownNumber: 0,
        minPrice: null,
        extremum: null,
        remarks: null,
        direction: null,
        payType: null,
        status: null,
        autoStatus: "UNOPEN",
        autoMsg: null,
        freeze: null,
        dealNum: null,
        createTime: null,
        updateTime: null,
        mccId:null,
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
      this.title = "添加OTC广告";
      this.getStoreList();
      this.getFbList();
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getOtcOrder(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改OTC广告";
        this.getStoreList();
        this.getFbList();
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateOtcOrder(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addOtcOrder(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除法币订单编号为"' + ids + '"的数据项？').then(function() {
        return delOtcOrder(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/otcOrder/export', {
        ...this.queryParams
      }, `otcOrder_${new Date().getTime()}.xlsx`)
    },
    //撤销
    handleRevoke(row){
      this.$modal.confirm('是否撤销该广告？').then(function() {
        return Revoke(row.id);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("成功撤销");
      }).catch(() => {});
    }
  }
};
</script>
<style scoped>
.inp{
  display: flex;
  align-items: center;
}
.inp i{
  margin: 0 5px;
}
</style>
