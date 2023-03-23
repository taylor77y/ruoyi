<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="108px">
      <!-- <el-form-item label="${comment}" prop="pairs">
        <el-input
          v-model="queryParams.pairs"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="主币" prop="mainCur">
        <el-input
          v-model="queryParams.mainCur"
          placeholder="请输入主币"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="代币" prop="tokenCur">
        <el-input
          v-model="queryParams.tokenCur"
          placeholder="请输入代币"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
      <el-form-item label="交易对" prop="pairsName">
        <el-input
          v-model="queryParams.pairsName"
          placeholder="请输入交易对"
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
      <!-- <el-form-item label="价格" prop="price">
        <el-input
          v-model="queryParams.price"
          placeholder="请输入价格"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="成交价格" prop="matchPrice">
        <el-input
          v-model="queryParams.matchPrice"
          placeholder="请输入成交价格"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="数量" prop="count">
        <el-input
          v-model="queryParams.count"
          placeholder="请输入数量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="percentageCount">
        <el-input
          v-model="queryParams.percentageCount"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="成交数量" prop="matchCount">
        <el-input
          v-model="queryParams.matchCount"
          placeholder="请输入成交数量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="剩余数量" prop="surplusCount">
        <el-input
          v-model="queryParams.surplusCount"
          placeholder="请输入剩余数量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="会员id" prop="member">
        <el-input
          v-model="queryParams.member"
          placeholder="请输入会员id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="手续费费率" prop="tradeRate">
        <el-input
          v-model="queryParams.tradeRate"
          placeholder="请输入手续费费率"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="状态" prop="state">
        <el-input
          v-model="queryParams.state"
          placeholder="请输入状态"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="手续费" prop="tradeFee">
        <el-input
          v-model="queryParams.tradeFee"
          placeholder="请输入手续费"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="撮合方" prop="matchMember">
        <el-input
          v-model="queryParams.matchMember"
          placeholder="请输入撮合方"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="撮合总额" prop="matchFee">
        <el-input
          v-model="queryParams.matchFee"
          placeholder="请输入撮合总额"
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
          v-hasPermi="['system:entrust:add']"
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
          v-hasPermi="['system:entrust:edit']"
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
          v-hasPermi="['system:entrust:remove']"
        >删除</el-button>
      </el-col> -->
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:entrust:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="entrustList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <!-- <el-table-column label="ID" align="center" prop="id" />
      <el-table-column label="${comment}" align="center" prop="pairs" />
      <el-table-column label="主币" align="center" prop="mainCur" />
      <el-table-column label="代币" align="center" prop="tokenCur" /> -->
      <el-table-column label="交易对" align="center" prop="pairsName" />
      <el-table-column label="价格" align="center" prop="price" />
      <el-table-column label="成交价格" align="center" prop="matchPrice" />
      <el-table-column label="数量" align="center" prop="count" />
      <!-- <el-table-column label="${comment}" align="center" prop="percentageCount" /> -->
      <el-table-column label="成交数量" align="center" prop="matchCount" />
      <el-table-column label="剩余数量" align="center" prop="surplusCount" />
      <el-table-column label="用户手机" align="center" prop="phone" />
      <el-table-column label="用户邮箱" align="center" prop="mail" />
      <!-- <el-table-column label="会员id" align="center" prop="member" /> -->
      <!-- <el-table-column label="${comment}" align="center" prop="memberType" /> -->
      <el-table-column label="手续费费率" align="center" prop="tradeRate" />
      <el-table-column label="委托类型" align="center" prop="entrustType" >
        <template slot-scope="scope">
          <dict-tag :options="dict.type.otc_fx" :value="scope.row.entrustType"/>
        </template>
      </el-table-column>
      <el-table-column label="成交方式" align="center" prop="methodType" />
      <!-- <el-table-column label="" align="center" prop="priceType" /> -->
      <el-table-column label="状态" align="center" prop="state" />
      <el-table-column label="手续费" align="center" prop="tradeFee" />
      <el-table-column label="撮合方" align="center" prop="matchMember" />
      <el-table-column label="撮合总额" align="center" prop="matchFee" />
      <el-table-column label="创建时间" align="center" prop="createTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createTime) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" fixed="right" width="150" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            v-if="scope.row.state != 'CLOSE'"
            @click="handleQR(scope.row)"
            v-hasPermi="['system:entrust:agree']"
          >确认</el-button>
          <el-button
            size="mini"
            type="text"
            v-if="scope.row.state == 'CREATE'"
            @click="handleCX(scope.row)"
            v-hasPermi="['system:entrust:cancel']"
          >撤销</el-button>
          <el-button
            size="mini"
            type="text"
            v-if="scope.row.state == 'MATCH'"
            @click="handleCX(scope.row)"
            v-hasPermi="['system:entrust:cancel']"
          >撤销</el-button>
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

    <!-- 添加或修改币币撮合对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="${comment}" prop="pairs">
          <el-input v-model="form.pairs" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="主币" prop="mainCur">
          <el-input v-model="form.mainCur" placeholder="请输入主币" />
        </el-form-item>
        <el-form-item label="代币" prop="tokenCur">
          <el-input v-model="form.tokenCur" placeholder="请输入代币" />
        </el-form-item>
        <el-form-item label="交易对" prop="pairsName">
          <el-input v-model="form.pairsName" placeholder="请输入交易对" />
        </el-form-item>
        <el-form-item label="价格" prop="price">
          <el-input v-model="form.price" placeholder="请输入价格" />
        </el-form-item>
        <el-form-item label="成交价格" prop="matchPrice">
          <el-input v-model="form.matchPrice" placeholder="请输入成交价格" />
        </el-form-item>
        <el-form-item label="数量" prop="count">
          <el-input v-model="form.count" placeholder="请输入数量" />
        </el-form-item>
        <el-form-item label="${comment}" prop="percentageCount">
          <el-input v-model="form.percentageCount" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="成交数量" prop="matchCount">
          <el-input v-model="form.matchCount" placeholder="请输入成交数量" />
        </el-form-item>
        <el-form-item label="剩余数量" prop="surplusCount">
          <el-input v-model="form.surplusCount" placeholder="请输入剩余数量" />
        </el-form-item>
        <el-form-item label="会员id" prop="member">
          <el-input v-model="form.member" placeholder="请输入会员id" />
        </el-form-item>
        <el-form-item label="手续费费率" prop="tradeRate">
          <el-input v-model="form.tradeRate" placeholder="请输入手续费费率" />
        </el-form-item>
        <el-form-item label="状态" prop="state">
          <el-input v-model="form.state" placeholder="请输入状态" />
        </el-form-item>
        <el-form-item label="手续费" prop="tradeFee">
          <el-input v-model="form.tradeFee" placeholder="请输入手续费" />
        </el-form-item>
        <el-form-item label="撮合方" prop="matchMember">
          <el-input v-model="form.matchMember" placeholder="请输入撮合方" />
        </el-form-item>
        <el-form-item label="撮合总额" prop="matchFee">
          <el-input v-model="form.matchFee" placeholder="请输入撮合总额" />
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
import { listEntrust, getEntrust, delEntrust, addEntrust, updateEntrust,cancelEntrust,agreeEntrust } from "@/api/system/entrust";

export default {
  name: "Entrust",
  dicts:['otc_fx'],
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
      // 币币撮合表格数据
      entrustList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        pairs: null,
        mainCur: null,
        tokenCur: null,
        pairsName: null,
        price: null,
        matchPrice: null,
        count: null,
        percentageCount: null,
        matchCount: null,
        surplusCount: null,
        member: null,
        memberType: null,
        tradeRate: null,
        entrustType: null,
        methodType: null,
        priceType: null,
        state: null,
        tradeFee: null,
        matchMember: null,
        matchFee: null,
        phone:null,
        mail:null,
        uuid:null,
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
    /** 查询币币撮合列表 */
    getList() {
      this.loading = true;
      listEntrust(this.queryParams).then(response => {
        this.entrustList = response.rows;
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
        pairs: null,
        mainCur: null,
        tokenCur: null,
        pairsName: null,
        price: null,
        matchPrice: null,
        count: null,
        percentageCount: null,
        matchCount: null,
        surplusCount: null,
        member: null,
        memberType: null,
        tradeRate: null,
        entrustType: null,
        methodType: null,
        priceType: null,
        state: null,
        tradeFee: null,
        matchMember: null,
        matchFee: null,
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
      this.title = "添加币币撮合";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getEntrust(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改币币撮合";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateEntrust(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addEntrust(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除币币撮合编号为"' + ids + '"的数据项？').then(function() {
        return delEntrust(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/entrust/export', {
        ...this.queryParams
      }, `entrust_${new Date().getTime()}.xlsx`)
    },
     /** 撤销 */
    handleCX(row) {
      this.$modal.confirm('是否撤销？').then(function() {
        return cancelEntrust(row.id);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("撤销成功");
      }).catch(() => {});
    },
     /** 确认 */
    handleQR(row) {
      this.$modal.confirm('是否确认？').then(function() {
        return agreeEntrust(row.id);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("操作成功");
      }).catch(() => {});
    },
  }
};
</script>
