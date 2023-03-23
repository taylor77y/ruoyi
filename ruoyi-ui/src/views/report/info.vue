<template>
  <div class="app-container">
    <el-row>
      <el-form ref="ruleForm" :inline="true" :model="ruleForm" :rules="rules" label-width="80px">
        <el-form-item label="查询条件" prop="info">
          <el-checkbox-group v-model="ruleForm.info">
            <el-checkbox label="会员认证" name="info"></el-checkbox>
            <el-checkbox label="会员充值" name="info"></el-checkbox>
            <el-checkbox label="虚拟上分" name="info"></el-checkbox>
            <el-checkbox label="法币购买" name="info"></el-checkbox>
          </el-checkbox-group>
        </el-form-item>
        <el-form-item label="时间" prop="time">
           <el-date-picker
              v-model="ruleForm.time"
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
      <el-table-column label="上级UUID" align="center" prop="welMemberUuid"/>
      <el-table-column label="业务员代码" align="center" prop="welMemberPhone"/>
      <el-table-column label="归属员工" align="center" prop="sysName"/>
      <el-table-column label="手机号" align="center" prop="phone" width="100"/>
      <el-table-column label="UUID" align="center" prop="uuid" width="100"/>
      <el-table-column label="邮箱" align="center" prop="mail" width="200"/>
      <el-table-column label="昵称" align="center" prop="nickName" width="200"/>
      <el-table-column label="头像" align="center" prop="handLink" width="100">
        <template slot-scope="scope">
          <image-preview :src="pathImg + scope.row.handLink" :width="50" :height="50"/>
        </template>
      </el-table-column>
      <el-table-column label="邀请码" align="center" prop="welCode" />
      <el-table-column label="账号类型" align="center" prop="useType" width="100">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.member_zh_type" :value="scope.row.useType"/>
        </template>
      </el-table-column>
      <el-table-column label="姓名" align="center" prop="uname" />
      <el-table-column label="身份证号" align="center" prop="cardNo" width="150"/>
      <el-table-column label="高级认证状态" align="center" prop="cardState" width="100">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.otc_card_state" :value="scope.row.cardState"/>
        </template>
      </el-table-column>
      <el-table-column label="是否是商家" align="center" prop="storeState" width="100">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.otc_store_state" :value="scope.row.storeState"/>
        </template>
      </el-table-column>
      <el-table-column label="区号" align="center" prop="areaCode" width="100">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.area_info" :value="scope.row.areaCode"/>
        </template>
      </el-table-column>
      <el-table-column label="封号状态" align="center" prop="userStatus">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.t_user_status" :value="scope.row.userStatus"/>
        </template>
      </el-table-column>
      <el-table-column label="是否控盘" align="center" prop="isControl">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.seconds_bet_control_status" :value="scope.row.isControl"/>
        </template>
      </el-table-column>
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="上次登录IP" align="center" prop="lastLoginIp" width="140">
        <template slot-scope="scope">
          <span v-if="scope.row.lastLoginIp == ''">暂无IP</span>
        </template>
      </el-table-column>
      <el-table-column label="注册时间" align="center" prop="createTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createTime) }}</span>
        </template>
      </el-table-column>
       <el-table-column label="操作" align="center" fixed="right" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-dropdown size="mini" @command="(command) => handleCommand(command, scope.row)">
            <span class="el-dropdown-link">
              <i class="el-icon-d-arrow-right el-icon--right"></i>更多
            </span>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item command="handleZCM" icon="el-icon-circle-check"
                v-hasPermi="['system:member:zcm']">资产查看</el-dropdown-item>
              <el-dropdown-item command="handlePid" icon="el-icon-circle-check"
                v-hasPermi="['system:member:lookDown']">查看下级</el-dropdown-item>
              <el-dropdown-item command="handleZJBG" icon="el-icon-circle-check"
                v-hasPermi="['system:member:zjbg']">资金变更</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="ruleForm.pageNum"
      :limit.sync="ruleForm.pageSize"
      @pagination="getList"
    />


      <!-- 资金查看 -->
    <el-dialog title="资金查看" :visible.sync="open4" width="800px" append-to-body>
      <el-row>
        <el-col :span="12">
          <el-card class="box-card">
            {{qbAmount}}
            <el-divider></el-divider>
            <div>
              钱包可用总资产(折合USDT)
            </div>
          </el-card>
        </el-col>
        <el-col :span="12">
          <el-card class="box-card">
            {{qbFreeze}}
            <el-divider></el-divider>
            <div>
              钱包冻结总资产(折合USDT)
            </div>
          </el-card>
        </el-col>
      </el-row>
        <div class="link"></div>
      <el-table :data="balanceList" height="400">
        <el-table-column label="币种" align="center" prop="currency" />
        <el-table-column label="钱包可用" align="center" prop="assetsBalance">
          <template slot-scope="scope">
            {{scope.row.assetsBalance }}
          </template>
        </el-table-column>
        <el-table-column label="钱包冻结" align="center" prop="assetsBlockedBalance">
          <template slot-scope="scope">
            {{scope.row.assetsBlockedBalance }}
          </template>
        </el-table-column>
      </el-table>
    </el-dialog>
    <!-- 查询下级 -->
    <el-dialog title="查看下级" :visible.sync="open5" width="1450px" append-to-body>
      <el-table :data="downMemberList">
        <el-table-column label="序号" type="index" align="center" width="50"/>
      <el-table-column label="上级UUID" align="center" prop="welMemberUuid"/>
      <el-table-column label="业务员代码" align="center" prop="welMemberPhone"/>
        <el-table-column label="归属员工" align="center" prop="sysName"/>
        <el-table-column label="手机号" align="center" prop="phone" width="100"/>
        <el-table-column label="UUID" align="center" prop="uuid" width="100"/>
        <el-table-column label="邮箱" align="center" prop="mail" width="200"/>
        <el-table-column label="昵称" align="center" prop="nickName" width="200"/>
      <el-table-column label="头像" align="center" prop="handLink" width="100">
        <template slot-scope="scope">
          <image-preview :src="pathImg + scope.row.handLink" :width="50" :height="50"/>
        </template>
      </el-table-column>
        <el-table-column label="邀请码" align="center" prop="welCode" />
        <el-table-column label="姓名" align="center" prop="uname" />
        <el-table-column label="身份证号" align="center" prop="cardNo" width="150"/>
        <el-table-column label="高级认证状态" align="center" prop="cardState" width="100">
          <template slot-scope="scope">
            <dict-tag :options="dict.type.otc_card_state" :value="scope.row.cardState"/>
          </template>
        </el-table-column>
        <el-table-column label="是否是商家" align="center" prop="storeState" width="100">
          <template slot-scope="scope">
            <dict-tag :options="dict.type.otc_store_state" :value="scope.row.storeState"/>
          </template>
        </el-table-column>
        <el-table-column label="区号" align="center" prop="areaCode" width="100">
          <template slot-scope="scope">
            <dict-tag :options="dict.type.area_info" :value="scope.row.areaCode"/>
          </template>
        </el-table-column>
        <el-table-column label="封号状态" align="center" prop="userStatus">
          <template slot-scope="scope">
            <dict-tag :options="dict.type.t_user_status" :value="scope.row.userStatus"/>
          </template>
        </el-table-column>
        <el-table-column label="是否控盘" align="center" prop="isControl">
          <template slot-scope="scope">
            <dict-tag :options="dict.type.seconds_bet_control_status" :value="scope.row.isControl"/>
          </template>
        </el-table-column>
        <el-table-column label="备注" align="center" prop="remark" />
        <el-table-column label="注册时间" align="center" prop="createTime" width="180">
          <template slot-scope="scope">
            <span>{{ parseTime(scope.row.createTime) }}</span>
          </template>
        </el-table-column>

      </el-table>
    </el-dialog>
    <!-- 资金记录 -->
    <el-dialog title="资金记录" :visible.sync="open8" width="1150px" append-to-body>
      <el-table :data="balanceRecordList">
        <el-table-column label="ID" align="center" prop="id" />
        <el-table-column label="用户UUID" align="center" prop="uuid" />
        <el-table-column label="手机号" align="center" prop="phone" />
        <el-table-column label="币种" align="center" prop="currency" />
        <el-table-column label="资金类型" align="center" prop="balanceType">
          <template slot-scope="scope">
            <dict-tag :options="dict.type.amount_change_type" :value="scope.row.balanceType"/>
          </template>
        </el-table-column>
        <el-table-column label="交易类型" align="center" prop="fundsType">
          <template slot-scope="scope">
            <dict-tag :options="dict.type.zj_funds_type" :value="scope.row.fundsType"/>
          </template>
        </el-table-column>
        <el-table-column label="资产变更前" align="center" prop="balanceBefore" />
        <el-table-column label="资产变更后" align="center" prop="balanceBack" />
        <el-table-column label="资产差额" align="center" prop="balanceDifference" />
        <el-table-column label="创建时间" align="center" prop="createTime" width="180">
          <template slot-scope="scope">
            <span>{{ parseTime(scope.row.createTime) }}</span>
          </template>
        </el-table-column>
      </el-table>

      <pagination
        v-show="total3>0"
        :total="total3"
        :page.sync="queryParams3.pageNum"
        :limit.sync="queryParams3.pageSize"
        @pagination="getZJJLList"
      />
    </el-dialog>
  </div>
</template>

<script>
import {
    getInfoData
} from "@/api/report";
import { getZCMS,finPList } from "@/api/system/member";
import { listBalanceRecord} from "@/api/system/balanceRecord";
export default {
  name: "info",
   dicts: ['area_info', 't_user_status', 'seconds_bet_control_status', 'otc_store_state', 'otc_card_state','member_zh_type','amount_change_type','ud_score_bf'],
  data() {
    return {
      open4:false,open5:false,open8:false,
      downMemberList:[],balanceRecordList:[],balanceList:[],
      total3:0,
      queryParams3: {
        pageNum: 1,
        pageSize: 10,
        memberId: null,
      },
      qbAmount:"",
      qbFreeze:"",  
      // 总条数
      total: 0,
      memberList:[],
      ruleForm:{
        uuid:null,
        time:null,
        info:[],
        pageNum: 1,
        pageSize: 10,
        openTime:null,
        closeTime:null,
      },
      rules: {
          info: [
            { required: true, message: '请选择查询条件', trigger: 'blur' },
          ],
      },
    };
  },
  computed: {
      pathImg() {
        return localStorage.getItem('imgPath')
      }
    },
  methods: {
     // 更多操作触发
    handleCommand(command, row) {
      switch (command) {
        case "handleZCM":
          this.handleZCM(row);
          break;
        case "handlePid":
          this.handlePid(row);
          break;
        case "handleZJBG":
          this.handleZJBG(row);
          break;
        default:
          break;
      }
    },
    /**
     * 资产查看
     */
    handleZCM(row){
      this.balanceList = [];
      this.open4 = true;
      getZCMS(row).then(res=>{
        console.log(res)
        this.balanceList = res.data.list;
        this.qbAmount = res.data.amount;
        this.qbFreeze = res.data.freeze;
      })
    },
    //查看下级
    handlePid(row){
      finPList(row.id).then(res=>{
        console.log(res.data)
        this.downMemberList = res.data
        this.open5 = true;
      })
    },
    //查看资金记录
    handleZJBG(row){
      this.queryParams3.pageNum = 1;
      this.queryParams3.memberId = row.id;
      this.open8 = true;
      this.getZJJLList();
    },
    /** 查询资金记录列表 */
    getZJJLList() {
      listBalanceRecord(this.queryParams3).then(response => {
        this.balanceRecordList = response.rows;
        this.total3 = response.total;
      });
    },
    getList(){
      getInfoData(this.ruleForm).then(res=>{
        console.log(res)
        this.memberList = res.rows;
        this.total = res.total;
      })
    },
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            console.log(this.ruleForm)
            if(this.ruleForm.time != null){
              this.ruleForm.openTime = this.ruleForm.time[0];
              this.ruleForm.closeTime = this.ruleForm.time[1];
            }
            this.getList();
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
        this.ruleForm.openTime = null,
        this.ruleForm.closeTime = null;
        this.memberList = [];
        this.total = 0;
      }
  }
};
</script>

<style scoped lang="scss">
.link{
  height: 20px;
}
</style>
