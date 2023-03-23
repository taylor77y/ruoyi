<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="108px">
      <el-form-item label="推荐人" prop="lastPhone">
        <el-input
          v-model="queryParams.lastPhone"
          placeholder="请输入推荐人(手机)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="用户UUID" prop="uuid">
        <el-input
          v-model="queryParams.uuid"
          placeholder="请输入用户UUID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <!-- <el-form-item label="用户手机" prop="phone">
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
      </el-form-item> -->
      <!-- <el-form-item label="数量" prop="balance">
        <el-input
          v-model="queryParams.balance"
          placeholder="请输入数量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="手续费" prop="handlingFee">
        <el-input
          v-model="queryParams.handlingFee"
          placeholder="请输入手续费"
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
      <el-form-item label="提币地址" prop="wallet">
        <el-input
          v-model="queryParams.wallet"
          placeholder="请输入提币地址"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="审核状态" prop="state">
        <el-select v-model="queryParams.state" placeholder="请选择审核状态" clearable>
          <el-option
            v-for="dict in dict.type.tibishenhe"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="php:交易hex/交易ID" prop="hex">
        <el-input
          v-model="queryParams.hex"
          placeholder="请输入php:交易hex/交易ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="php:出方地址" prop="fromAddress">
        <el-input
          v-model="queryParams.fromAddress"
          placeholder="请输入php:出方地址"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="php:收方地址" prop="toAddress">
        <el-input
          v-model="queryParams.toAddress"
          placeholder="请输入php:收方地址"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="php:转账数量" prop="tokenNumber">
        <el-input
          v-model="queryParams.tokenNumber"
          placeholder="请输入php:转账数量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="php:时间" prop="extractTime">
        <el-date-picker clearable
          v-model="queryParams.extractTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择php:时间">
        </el-date-picker>
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
          v-hasPermi="['system:extractCoin:add']"
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
          v-hasPermi="['system:extractCoin:edit']"
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
          v-hasPermi="['system:extractCoin:remove']"
        >删除</el-button>
      </el-col> -->
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:extractCoin:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="extractCoinList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <!-- <el-table-column label="ID" align="center" prop="id" /> -->
     
      <el-table-column label="用户名" align="center" prop="smName" />
      <el-table-column label="UUID" align="center" prop="uuid"  width="100" />
      <el-table-column label="账号类型" align="center" prop="useType" width="100">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.member_zh_type" :value="scope.row.useType"/>
        </template>
      </el-table-column>
       <el-table-column label="推荐人" align="center" prop="lastPhone" width="200" />
      <el-table-column label="链名" align="center" prop="chainName" />
      <el-table-column label="数量" align="center" prop="balance" width="100">
        <template slot-scope="scope">
          <el-tag type="danger">{{scope.row.balance}}</el-tag>
        </template>
      </el-table-column>
      <el-table-column label="手续费" align="center" prop="handlingFee" />
      <el-table-column label="币种" align="center" prop="currency" />
      <el-table-column label="提币地址" align="center" prop="wallet">
        <template slot-scope="scope">
          <el-tag @click="lookWallet(scope.row)">查看地址</el-tag>
        </template>
      </el-table-column>
      <el-table-column label="审核状态" align="center" prop="state">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.tibishenhe" :value="scope.row.state"/>
        </template>
      </el-table-column>
      <el-table-column label="类型" align="center" prop="type" width="100">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.extract_coin_type" :value="scope.row.type"/>
        </template>
      </el-table-column>
      <el-table-column label="汇率" align="center" prop="exchangeRate"/>
      <el-table-column label="换算后金额" align="center" prop="amount" width="100"/>
      <el-table-column label="货币符号" align="center" prop="currencySymbol"/>
      <el-table-column label="银行卡姓名" align="center" prop="bankUserName" width="200"/>
      <el-table-column label="银行名称" align="center" prop="bankName" width="200"/>
      <el-table-column label="开户行" align="center" prop="bankAddress" width="200"/>
      <el-table-column label="银行卡姓名" align="center" prop="bankCard" width="200"/>
      <!-- <el-table-column label="php:交易hex/交易ID" align="center" prop="hex" />
      <el-table-column label="php:交易区块页面" align="center" prop="viewInExplorer" />
      <el-table-column label="php:出方地址" align="center" prop="fromAddress" />
      <el-table-column label="php:收方地址" align="center" prop="toAddress" />
      <el-table-column label="php:转账数量" align="center" prop="tokenNumber" />
      <el-table-column label="php:时间" align="center" prop="extractTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.extractTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column> -->
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
      <el-table-column label="操作" fixed="right" align="center" width="200" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <!-- <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:extractCoin:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:extractCoin:remove']"
          >删除</el-button> -->
          <el-button
            size="mini"
            type="text"
            v-if="scope.row.state == 'CREATE'"
            icon="el-icon-view"
            @click="handleAgree(scope.row)"
            v-hasPermi="['system:extractCoin:agree']"
          >通过</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-view"
            v-if="scope.row.state == 'CREATE'"
            @click="handleReject(scope.row)"
            v-hasPermi="['system:extractCoin:reject']"
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

    <!-- 添加或修改提币审核对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="用户id" prop="member">
          <el-input v-model="form.member" placeholder="请输入用户id" />
        </el-form-item>
        <el-form-item label="数量" prop="balance">
          <el-input v-model="form.balance" placeholder="请输入数量" />
        </el-form-item>
        <el-form-item label="手续费" prop="handlingFee">
          <el-input v-model="form.handlingFee" placeholder="请输入手续费" />
        </el-form-item>
        <el-form-item label="币种" prop="currency">
          <el-input v-model="form.currency" placeholder="请输入币种" />
        </el-form-item>
        <el-form-item label="提币地址" prop="wallet">
          <el-input v-model="form.wallet" placeholder="请输入提币地址" />
        </el-form-item>
        <el-form-item label="审核状态" prop="state">
          <el-select v-model="form.state" placeholder="请选择审核状态">
            <el-option
              v-for="dict in dict.type.tibishenhe"
              :key="dict.value"
              :label="dict.label"
:value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="php:交易hex/交易ID" prop="hex">
          <el-input v-model="form.hex" placeholder="请输入php:交易hex/交易ID" />
        </el-form-item>
        <el-form-item label="php:交易区块页面" prop="viewInExplorer">
          <el-input v-model="form.viewInExplorer" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="php:出方地址" prop="fromAddress">
          <el-input v-model="form.fromAddress" placeholder="请输入php:出方地址" />
        </el-form-item>
        <el-form-item label="php:收方地址" prop="toAddress">
          <el-input v-model="form.toAddress" placeholder="请输入php:收方地址" />
        </el-form-item>
        <el-form-item label="php:转账数量" prop="tokenNumber">
          <el-input v-model="form.tokenNumber" placeholder="请输入php:转账数量" />
        </el-form-item>
        <el-form-item label="php:时间" prop="extractTime">
          <el-date-picker clearable
            v-model="form.extractTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择php:时间">
          </el-date-picker>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>

     <!-- 查看 -->
    <el-dialog title="查看详情" :visible.sync="open2" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <!-- <el-form-item label="用户id" prop="member">
          <el-input v-model="form.member" placeholder="请输入用户id" />
        </el-form-item> -->
        <el-form-item label="数量" prop="balance">
          <el-input disabled v-model="form.balance" placeholder="请输入数量" />
        </el-form-item>
        <el-form-item label="手续费" prop="handlingFee">
          <el-input disabled v-model="form.handlingFee" placeholder="请输入手续费" />
        </el-form-item>
        <el-form-item label="币种" prop="currency">
          <el-input disabled v-model="form.currency" placeholder="请输入币种" />
        </el-form-item>
        <el-form-item label="提币地址" prop="wallet">
          <el-input disabled v-model="form.wallet" placeholder="请输入提币地址" />
        </el-form-item>
      </el-form>
    </el-dialog>
  </div>
</template>

<script>
import { listExtractCoin, getExtractCoin, delExtractCoin, addExtractCoin, updateExtractCoin,Agree,Reject } from "@/api/system/extractCoin";
import { checkOperPwd} from "@/api/census";
export default {
  name: "ExtractCoin",
  dicts: ['tibishenhe','extract_coin_type','member_zh_type'],
  data() {
    return {
      open2:false,
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
      // 提币审核表格数据
      extractCoinList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        member: null,
        balance: null,
        handlingFee: null,
        currency: null,
        wallet: null,
        state: null,
        hex: null,
        viewInExplorer: null,
        fromAddress: null,
        toAddress: null,
        tokenNumber: null,
        extractTime: null,
        phone:null,
        mail:null,
        uuid:null,
        lastPhone:null,
        lastSmName:null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        handlingFee: [
          { required: true, message: "手续费不能为空", trigger: "blur" }
        ],
        hex: [
          { required: true, message: "php:交易hex/交易ID不能为空", trigger: "blur" }
        ],
        viewInExplorer: [
          { required: true, message: "php:交易区块页面不能为空", trigger: "blur" }
        ],
        fromAddress: [
          { required: true, message: "php:出方地址不能为空", trigger: "blur" }
        ],
        toAddress: [
          { required: true, message: "php:收方地址不能为空", trigger: "blur" }
        ],
        tokenNumber: [
          { required: true, message: "php:转账数量不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    //查看地址
    lookWallet(row){
      console.log(row)
      this.form = row;
      this.open2 = true;
    },
    /** 查询提币审核列表 */
    getList() {
      this.loading = true;
      listExtractCoin(this.queryParams).then(response => {
        this.extractCoinList = response.rows;
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
        member: null,
        balance: null,
        handlingFee: null,
        currency: null,
        wallet: null,
        state: null,
        hex: null,
        viewInExplorer: null,
        fromAddress: null,
        toAddress: null,
        tokenNumber: null,
        extractTime: null,
        updateTime: null,
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
      this.title = "添加提币审核";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getExtractCoin(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改提币审核";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateExtractCoin(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addExtractCoin(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除提币审核编号为"' + ids + '"的数据项？').then(function() {
        return delExtractCoin(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/extractCoin/export', {
        ...this.queryParams
      }, `extractCoin_${new Date().getTime()}.xlsx`)
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
            this.$modal.confirm('确定通过此提币审核吗？').then(function() {
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
            this.$modal.confirm('确定驳回此提币审核吗？').then(function() {
              return Reject(row.id);
            }).then(() => {
              this.getList();
              this.$modal.msgSuccess("成功驳回");
            }).catch(() => {});;
          }
        })
      }).catch(() => {});
      
    }
  }
};
</script>
