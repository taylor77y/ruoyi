<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="108px">
       <el-form-item label="上级用户手机" prop="lastUserPhone">
        <el-input
          v-model="queryParams.lastUserPhone"
          placeholder="请输入上级用户手机"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="用户UUID" prop="userUuid">
        <el-input
          v-model="queryParams.userUuid"
          placeholder="请输入用户UUID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="用户手机" prop="userPhone">
        <el-input
          v-model="queryParams.userPhone"
          placeholder="请输入用户手机"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="用户邮箱" prop="userMail">
        <el-input
          v-model="queryParams.userMail"
          placeholder="请输入用户邮箱"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="买卖方式" prop="storeDirection">
        <el-select v-model="queryParams.storeDirection" placeholder="请选择买卖方式" clearable>
          <el-option
            v-for="dict in dict.type.otc_fx"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="订单状态" prop="status">
        <el-select v-model="queryParams.status" placeholder="请选择订单状态" clearable>
          <el-option
            v-for="dict in dict.type.otc_order_price"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="广告id" prop="orderId">
        <el-input
          v-model="queryParams.orderId"
          placeholder="请输入广告id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <!-- <el-form-item label="用户方向" prop="userDirection">
        <el-select v-model="queryParams.userDirection" placeholder="请选择用户方向" clearable>
          <el-option
            v-for="dict in dict.type.otc_fx"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="商家方向" prop="storeDirection">
        <el-select v-model="queryParams.storeDirection" placeholder="请选择商家方向" clearable>
          <el-option
            v-for="dict in dict.type.otc_fx"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="下单数量" prop="num">
        <el-input
          v-model="queryParams.num"
          placeholder="请输入下单数量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="价格" prop="price">
        <el-input
          v-model="queryParams.price"
          placeholder="请输入价格"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="总价" prop="totalPrice">
        <el-input
          v-model="queryParams.totalPrice"
          placeholder="请输入总价"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="付款类型" prop="payType">
        <el-select v-model="queryParams.payType" placeholder="请选择付款类型" clearable>
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
            v-for="dict in dict.type.otc_order_price"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="币种" prop="currency">
        <el-input
          v-model="queryParams.currency"
          placeholder="请输入币种"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="申诉状态" prop="appealStatus">
        <el-select v-model="queryParams.appealStatus" placeholder="请选择申诉状态" clearable>
          <el-option
            v-for="dict in dict.type.otc_shensu_status"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="申诉id" prop="appealUserId">
        <el-input
          v-model="queryParams.appealUserId"
          placeholder="请输入申诉id"
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
          v-hasPermi="['system:otcOrderPrice:add']"
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
          v-hasPermi="['system:otcOrderPrice:edit']"
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
          v-hasPermi="['system:otcOrderPrice:remove']"
        >删除</el-button>
      </el-col> -->
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:otcOrderPrice:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="otcOrderPriceList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <!-- <el-table-column label="订单id" align="center" prop="id" width="300"/> -->
      <el-table-column label="上级用户手机" align="center" prop="lastUserPhone"/>
      <el-table-column label="用户UUID" align="center" prop="userUuid"/>
      <el-table-column label="用户手机" align="center" prop="userPhone" />
      <el-table-column label="账号类型" align="center" prop="useType" width="100">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.member_zh_type" :value="scope.row.useType"/>
        </template>
      </el-table-column>
      <el-table-column label="商家手机" align="center" prop="storePhone" />
      <!-- <el-table-column label="广告id" align="center" prop="orderId" width="300" /> -->
      <el-table-column label="买家方向" align="center" prop="storeDirection">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.otc_fx" :value="scope.row.storeDirection"/>
        </template>
        </el-table-column>
      <el-table-column label="卖家方向" align="center" prop="userDirection">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.otc_fx" :value="scope.row.userDirection"/>
        </template>
      </el-table-column>


      <el-table-column label="USDT数量" align="center" prop="num" />
      <el-table-column label="币种单价" align="center" prop="price" />
      <el-table-column label="货币" align="center" prop="memberCurrencyConfig">
        <template slot-scope="scope">
          {{scope.row.memberCurrencyConfig.currencyName}}
        </template>
      </el-table-column>
      <el-table-column label="货币符号" align="center" prop="memberCurrencyConfig">
        <template slot-scope="scope">
          {{scope.row.memberCurrencyConfig.mark}}
        </template>
      </el-table-column>
      <el-table-column label="货币单价" align="center" prop="memberCurrencyConfig">
        <template slot-scope="scope">
          {{scope.row.memberCurrencyConfig.rate}}
        </template>
      </el-table-column>
      <el-table-column label="支付金额" align="center" prop="totalPrice" />
      <el-table-column label="付款类型" align="center" prop="payType">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.otc_pay_type" :value="scope.row.payType"/>
        </template>
      </el-table-column>
      <el-table-column label="订单状态" align="center" prop="status">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.otc_order_price" :value="scope.row.status"/>
        </template>
      </el-table-column>
      <el-table-column label="币种" align="center" prop="currency" />
      <el-table-column label="申诉状态" align="center" prop="appealStatus">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.otc_shensu_status" :value="scope.row.appealStatus"/>
        </template>
      </el-table-column>
      <el-table-column label="申诉手机" align="center" prop="appealUserPhone" />
      <el-table-column label="申诉邮箱" align="center" prop="appealUserMail" />
      <el-table-column label="创建时间" align="center" prop="createTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createTime) }}</span>
        </template>
      </el-table-column>
       <el-table-column label="更新时间" align="center" prop="createTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.updateTime) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" fixed="right" width="100" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <!-- <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:otcOrderPrice:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"

                        v-if="scope.row.storeDirection == 'PAYMENT'"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:otcOrderPrice:remove']"
          >删除</el-button> -->
          <el-button
            size="mini"
            type="text"
            v-if=" scope.row.status == 'NONPAYMENT' && scope.row.storeDirection == 'BUY'"
            icon="el-icon-view"
            @click="handleSure(scope.row)"
            v-hasPermi="['system:otcOrderPrice:sure']"
          >确认订单</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-view"
            v-if="scope.row.status == 'NONPAYMENT' && scope.row.storeDirection == 'BUY'"
            @click="handleCancel(scope.row)"
            v-hasPermi="['system:otcOrderPrice:cancel']"
          >取消订单</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-view"
            v-if=" scope.row.status == 'PAYMENT' && scope.row.storeDirection == 'SELL'"
            @click="handleRelease(scope.row)"
            v-hasPermi="['system:otcOrderPrice:release']"
          >手动放行</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-view"
            v-if=" scope.row.status == 'NONPAYMENT' && scope.row.storeDirection == 'SELL'"
            @click="handleRelease(scope.row)"
            v-hasPermi="['system:otcOrderPrice:release']"
          >手动放行</el-button>
           <el-button
            size="mini"
            type="text"
            icon="el-icon-view"
            v-if="scope.row.status == 'PAYMENT' && scope.row.storeDirection == 'SELL'"
            @click="handleCancel(scope.row)"
            v-hasPermi="['system:otcOrderPrice:cancel']"
          >取消订单</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-view"
            v-if="scope.row.status == 'NONPAYMENT' && scope.row.storeDirection == 'SELL'"
            @click="handleCancel(scope.row)"
            v-hasPermi="['system:otcOrderPrice:cancel']"
          >取消订单</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-view"
            @click="handleLookChat(scope.row)"
            v-hasPermi="['system:otcOrderPrice:lookChat']">查看聊天</el-button>
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

    <!-- 添加或修改下单对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="用户id" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入用户id" />
        </el-form-item>
        <el-form-item label="商家id" prop="storeId">
          <el-input v-model="form.storeId" placeholder="请输入商家id" />
        </el-form-item>
        <el-form-item label="订单id" prop="orderId">
          <el-input v-model="form.orderId" placeholder="请输入订单id" />
        </el-form-item>
        <el-form-item label="用户方向" prop="userDirection">
          <el-select v-model="form.userDirection" placeholder="请选择用户方向">
            <el-option
              v-for="dict in dict.type.otc_fx"
              :key="dict.value"
              :label="dict.label"
:value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="商家方向" prop="storeDirection">
          <el-select v-model="form.storeDirection" placeholder="请选择商家方向">
            <el-option
              v-for="dict in dict.type.otc_fx"
              :key="dict.value"
              :label="dict.label"
:value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="下单数量" prop="num">
          <el-input v-model="form.num" placeholder="请输入下单数量" />
        </el-form-item>
        <el-form-item label="价格" prop="price">
          <el-input v-model="form.price" placeholder="请输入价格" />
        </el-form-item>
        <el-form-item label="总价" prop="totalPrice">
          <el-input v-model="form.totalPrice" placeholder="请输入总价" />
        </el-form-item>
        <el-form-item label="付款类型" prop="payType">
          <el-select v-model="form.payType" placeholder="请选择付款类型">
            <el-option
              v-for="dict in dict.type.otc_pay_type"
              :key="dict.value"
              :label="dict.label"
:value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="订单状态" prop="status">
          <el-select v-model="form.status" placeholder="请选择订单状态">
            <el-option
              v-for="dict in dict.type.otc_order_price"
              :key="dict.value"
              :label="dict.label"
:value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="币种" prop="currency">
          <el-input v-model="form.currency" placeholder="请输入币种" />
        </el-form-item>
        <el-form-item label="申诉状态" prop="appealStatus">
          <el-select v-model="form.appealStatus" placeholder="请选择申诉状态">
            <el-option
              v-for="dict in dict.type.otc_shensu_status"
              :key="dict.value"
              :label="dict.label"
:value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="申诉id" prop="appealUserId">
          <el-input v-model="form.appealUserId" placeholder="请输入申诉id" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
    <!-- 商家聊天 -->
    <el-dialog title="查看聊天" :visible.sync="chatOpen" width="1100px" append-to-body></el-dialog>
  </div>
</template>

<script>
import { listOtcOrderPrice, getOtcOrderPrice, delOtcOrderPrice, addOtcOrderPrice, updateOtcOrderPrice,Release,sureOrder,cancelOrder } from "@/api/system/otcOrderPrice";
import { checkOperPwd} from "@/api/census";
export default {
  name: "OtcOrderPrice",
  dicts: ['otc_shensu_status', 'otc_pay_type', 'otc_order_price', 'otc_fx','member_zh_type'],
  data() {
    return {
      chatOpen:false,
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
      // 下单表格数据
      otcOrderPriceList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        userId: null,
        storeId: null,
        orderId: null,
        userDirection: null,
        storeDirection: null,
        num: null,
        price: null,
        totalPrice: null,
        payType: null,
        status: null,
        currency: null,
        appealStatus: null,
        appealUserId: null,
        userPhone:null,
        userMail:null,
        userUuid:null,
        lastUserPhone:null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        userId: [
          { required: true, message: "用户id不能为空", trigger: "blur" }
        ],
        currency: [
          { required: true, message: "币种不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询下单列表 */
    getList() {
      this.loading = true;
      listOtcOrderPrice(this.queryParams).then(response => {
        this.otcOrderPriceList = response.rows;
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
        userId: null,
        storeId: null,
        orderId: null,
        userDirection: null,
        storeDirection: null,
        num: null,
        price: null,
        totalPrice: null,
        payType: null,
        status: null,
        currency: null,
        appealStatus: null,
        appealUserId: null,
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
      this.title = "添加下单";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getOtcOrderPrice(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改下单";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateOtcOrderPrice(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addOtcOrderPrice(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除下单编号为"' + ids + '"的数据项？').then(function() {
        return delOtcOrderPrice(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/otcOrderPrice/export', {
        ...this.queryParams
      }, `otcOrderPrice_${new Date().getTime()}.xlsx`)
    },
    //确认订单
    handleSure(row){
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
            this.$modal.confirm('是否确认订单？').then(function() {
              return sureOrder(row.id);
            }).then(() => {
              this.getList();
              this.$modal.msgSuccess("操作成功");
            }).catch(() => {});
          }
        })
      }).catch(() => {});
      
    },
    //取消订单
    handleCancel(row){
      
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
            this.$modal.confirm('是否取消订单？').then(function() {
              return cancelOrder(row.id);
            }).then(() => {
              this.getList();
              this.$modal.msgSuccess("操作成功");
            }).catch(() => {});
          }
        })
      }).catch(() => {});
    },
    //手动放行
    handleRelease(row){
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
            this.$modal.confirm('是否放行？').then(function() {
              return Release(row.id);
            }).then(() => {
              this.getList();
              this.$modal.msgSuccess("操作成功");
            }).catch(() => {});
          }
        })
      }).catch(() => {});
      
    },
    //商家聊天
    handleLookChat(row){
      this.$router.push({ path: "/fack/otcOrderPrice/index/chat?id="+row.id+'&sid='+row.storeId }).catch(()=>{});
    }
  }
};
</script>
