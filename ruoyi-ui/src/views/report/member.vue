<template>
  <div class="app-container">
    <el-row>
      <el-form ref="ruleForm" :inline="true" :model="ruleForm" :rules="rules" label-width="80px">
        <el-form-item label="UUID" prop="uuid">
          <el-input v-model="ruleForm.uuid" placeholder="请输入UUID"></el-input>
        </el-form-item>
        <el-form-item label="时间" prop="info">
           <el-date-picker
              v-model="ruleForm.info"
              type="daterange"
              range-separator="至"
              start-placeholder="开始日期"
              end-placeholder="结束日期">
            </el-date-picker>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitForm('ruleForm')">查询</el-button>
          <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
      </el-form>

    </el-row>
    <el-table :data="memberList">
      <el-table-column label="用户信息" align="center">
        <el-table-column label="UUID" align="center" prop="uuid" width="100"/>
        <el-table-column label="账号类型" align="center" prop="useType" width="100">
          <template slot-scope="scope">
            <dict-tag :options="dict.type.member_zh_type" :value="scope.row.useType"/>
          </template>
        </el-table-column>
      </el-table-column>
      <el-table-column label="充值" align="center">
        <el-table-column label="BTC" align="center" prop="btcAmount" width="100"/>
        <el-table-column label="ETH" align="center" prop="ethAmount" width="100"/>
        <el-table-column label="USDT" align="center" prop="usdtAmount" width="100"/>
      </el-table-column>
      <el-table-column label="提现" align="center">
        <el-table-column label="USDT" align="center" prop="txAmount" width="100"/>
      </el-table-column>
      <el-table-column label="法币交易" align="center">
        <el-table-column label="法币购买(USDT)" align="center" prop="fbBuyAmount" width="150"/>
        <el-table-column label="法币出售(UDST)" align="center" prop="fbSellAmount" width="150"/>
      </el-table-column>
      <el-table-column label="秒合约交易" align="center">
        <el-table-column label="秒合约赢(USDT)" align="center" prop="mhyWinAmount" width="150"/>
        <el-table-column label="秒合约输(UDST)" align="center" prop="mhyDonateAmount" width="150"/>
        <el-table-column label="秒合约盈亏(UDST)" align="center" width="150">
          <template slot-scope="scope">
            <span>{{scope.row.mhyWinAmount - scope.row.mhyDonateAmount}}</span>
          </template>
        </el-table-column>
      </el-table-column>
      <!-- <el-table-column label="币币交易" align="center">
        <el-table-column label="盈亏(USDT)" align="center" prop="uuid" width="150"/>
      </el-table-column>
      <el-table-column label="永续合约交易" align="center">
        <el-table-column label="盈亏(USDT)" align="center" prop="uuid" width="150"/>
      </el-table-column> -->
      <el-table-column label="虚拟充值" align="center">
        <el-table-column label="上分(USDT)" align="center" prop="xnUpAmount" width="150"/>
        <el-table-column label="上分(BTC)" align="center" prop="xnUpAmountBTC" width="150"/>
        <el-table-column label="上分(ETH)" align="center" prop="xnUpAmountETH" width="150"/>
        <el-table-column label="下分(UDST)" align="center" prop="xnDownAmount" width="150"/>
        <el-table-column label="下分(BTC)" align="center" prop="xnDownAmountBTC" width="150"/>
        <el-table-column label="下分(ETH)" align="center" prop="xnDownAmountETH" width="150"/>
      </el-table-column>
    </el-table>

    <!-- <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    /> -->

  </div>
</template>

<script>
import {
    getUserData
} from "@/api/report";
export default {
  name: "memberNow",
  dicts:['member_zh_type'],
  data() {
    return {
      ruleForm:{
        uuid:null,
        info:[]
      },
      rules: {
          uuid: [
            { required: true, message: '请输入UUID', trigger: 'blur' },
          ],
      },
      // 遮罩层
      loading: true,
      // 总条数
      total: 0,
      // 会员表格数据
      memberList: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        uuid: null,
        openTime:null,
        closeTime:null,
      },
    };
  },
  created() {
    // this.getList();
  },
  methods: {
    /** 查询会员列表 */
    getList() {
      this.loading = true;
      getUserData(this.queryParams).then(response => {
        console.log(response)
        this.memberList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.queryParams.uuid = this.ruleForm.uuid
            console.log(this.ruleForm)
              this.queryParams.openTime = this.ruleForm.info ? this.ruleForm.info[0] : null;
              this.queryParams.closeTime = this.ruleForm.info ? this.ruleForm.info[1] : null;
            console.log("请求参数",this.queryParams)
            getUserData(this.queryParams).then(response => {
              console.log("查询结果",response)
              this.memberList = response.rows;
              this.total = response.total;
              this.loading = false;
            });
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
        this.ruleForm.info = null;
      }
  }
};
</script>

<style scoped lang="scss">
.link{
  height: 20px;
}
</style>
