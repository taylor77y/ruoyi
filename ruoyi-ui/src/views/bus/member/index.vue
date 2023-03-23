<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="98px">
      <el-form-item label="手机号" prop="phone">
        <el-input
          v-model="queryParams.phone"
          placeholder="请输入手机号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="UUID" prop="uuid">
        <el-input
          v-model="queryParams.uuid"
          placeholder="请输入UUID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="邮箱" prop="mail">
        <el-input
          v-model="queryParams.mail"
          placeholder="请输入邮箱"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <!-- <el-form-item label="登录密码" prop="password">
        <el-input
          v-model="queryParams.password"
          placeholder="请输入登录密码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
      <el-form-item label="UUID(上级)" prop="welMemberUuid">
        <el-input
          v-model="queryParams.welMemberUuid"
          placeholder="请输入UUID(上级)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="业务员代码" prop="welMemberPhone">
        <el-input
          v-model="queryParams.welMemberPhone"
          placeholder="业务员代码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <!-- <el-form-item label="佣金" prop="brokerage">
        <el-input
          v-model="queryParams.brokerage"
          placeholder="请输入佣金"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
      <el-form-item label="邀请码" prop="welCode">
        <el-input
          v-model="queryParams.welCode"
          placeholder="请输入邀请码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <!-- <el-form-item label="支付密码" prop="payPassword">
        <el-input
          v-model="queryParams.payPassword"
          placeholder="请输入支付密码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
      <el-form-item label="姓名" prop="uname">
        <el-input
          v-model="queryParams.uname"
          placeholder="请输入姓名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <!-- <el-form-item label="出生日期" prop="birth">
        <el-input
          v-model="queryParams.birth"
          placeholder="请输入出生日期"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
      <el-form-item label="身份证号" prop="cardNo">
        <el-input
          v-model="queryParams.cardNo"
          placeholder="请输入身份证号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <!-- <el-form-item label="${comment}" prop="address">
        <el-input
          v-model="queryParams.address"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="quickMark">
        <el-input
          v-model="queryParams.quickMark"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是(1)否(0)" prop="broker">
        <el-input
          v-model="queryParams.broker"
          placeholder="请输入是(1)否(0)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="经纪人等级一" prop="brokerGradeOne">
        <el-input
          v-model="queryParams.brokerGradeOne"
          placeholder="请输入经纪人等级一"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="经纪人等级二" prop="brokerGradeTwo">
        <el-input
          v-model="queryParams.brokerGradeTwo"
          placeholder="请输入经纪人等级二"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="经纪人等级三" prop="brokerGradeThree">
        <el-input
          v-model="queryParams.brokerGradeThree"
          placeholder="请输入经纪人等级三"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
      <!-- <el-form-item label="银行卡所属行" prop="nickName">
        <el-input
          v-model="queryParams.nickName"
          placeholder="请输入银行卡所属行"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="微信图片" prop="payWechat">
        <el-input
          v-model="queryParams.payWechat"
          placeholder="请输入微信图片"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="支付宝图片" prop="payAliay">
        <el-input
          v-model="queryParams.payAliay"
          placeholder="请输入支付宝图片"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="微信姓名" prop="wechatName">
        <el-input
          v-model="queryParams.wechatName"
          placeholder="请输入微信姓名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="支付宝姓名" prop="aliayName">
        <el-input
          v-model="queryParams.aliayName"
          placeholder="请输入支付宝姓名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="身份证反面" prop="sideLink">
        <el-input
          v-model="queryParams.sideLink"
          placeholder="请输入身份证反面"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="身份证正面" prop="positiveLink">
        <el-input
          v-model="queryParams.positiveLink"
          placeholder="请输入身份证正面"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
      <el-form-item label="高级认证状态" prop="cardState">
        <el-select v-model="queryParams.cardState" placeholder="请选择高级认证状态" clearable>
          <el-option
            v-for="dict in dict.type.otc_card_state"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <!-- <el-form-item label="商家昵称" prop="storeName">
        <el-input
          v-model="queryParams.storeName"
          placeholder="请输入商家昵称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="银行卡姓名" prop="bankUserName">
        <el-input
          v-model="queryParams.bankUserName"
          placeholder="请输入银行卡姓名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="银行卡所属行" prop="bankName">
        <el-input
          v-model="queryParams.bankName"
          placeholder="请输入银行卡所属行"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="银行卡支行" prop="bankAddress">
        <el-input
          v-model="queryParams.bankAddress"
          placeholder="请输入银行卡支行"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="银行卡号" prop="bankCard">
        <el-input
          v-model="queryParams.bankCard"
          placeholder="请输入银行卡号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
      <el-form-item label="是否是商家" prop="storeState">
        <el-select v-model="queryParams.storeState" placeholder="请选择是否是商家" clearable>
          <el-option
            v-for="dict in dict.type.otc_store_state"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="区号" prop="areaCode">
        <el-select v-model="queryParams.areaCode" placeholder="请选择区号" clearable>
          <el-option
            v-for="dict in dict.type.area_info"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <!-- <el-form-item label="手持身份证照片" prop="handLink">
        <el-input
          v-model="queryParams.handLink"
          placeholder="请输入手持身份证照片"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
      <el-form-item label="封号状态" prop="userStatus">
        <el-select v-model="queryParams.userStatus" placeholder="请选择封号状态" clearable>
          <el-option
            v-for="dict in dict.type.t_user_status"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="账号类型" prop="useType">
        <el-select v-model="queryParams.useType" placeholder="请选择账号类型" clearable>
          <el-option
            v-for="dict in dict.type.member_zh_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <!-- <el-form-item label="法币配置ID" prop="oucId">
        <el-input
          v-model="queryParams.oucId"
          placeholder="请输入法币配置ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
      <el-form-item label="是否控盘" prop="isControl">
        <el-select v-model="queryParams.isControl" placeholder="请选择是否控盘" clearable>
          <el-option
            v-for="dict in dict.type.seconds_bet_control_status"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <!-- <el-form-item label="xxx" prop="isBok">
        <el-input
          v-model="queryParams.isBok"
          placeholder="请输入xxx"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
       <el-form-item label="归属员工ID" prop="sysId">
        <el-input
          v-model="queryParams.sysId"
          placeholder="请输入归属员工ID"
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
      <!-- <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:member:add']"
        >新增</el-button>
      </el-col> -->
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:member:edit']"
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
          v-hasPermi="['system:member:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:member:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="memberList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <!-- <el-table-column label="ID" align="center" prop="id" width="300"/> -->
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
      <!-- <el-table-column label="登录密码" align="center" prop="password" /> -->
      <!-- <el-table-column label="邀请人id" align="center" prop="welMember" />
      <el-table-column label="佣金" align="center" prop="brokerage" /> -->
      <el-table-column label="邀请码" align="center" prop="welCode" />
      <!-- <el-table-column label="支付密码" align="center" prop="payPassword" /> -->
      <el-table-column label="账号类型" align="center" prop="useType" width="100">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.member_zh_type" :value="scope.row.useType"/>
        </template>
      </el-table-column>
      <!-- <el-table-column label=":INTERNAL内部的,EXTERNAL外部的" align="center" prop="type" /> -->
      <el-table-column label="姓名" align="center" prop="uname" />
      <!-- <el-table-column label="性别" align="center" prop="sex" /> -->
      <!-- <el-table-column label="出生日期" align="center" prop="birth" /> -->
      <el-table-column label="身份证号" align="center" prop="cardNo" width="150"/>
      <!-- <el-table-column label="${comment}" align="center" prop="address" />
      <el-table-column label="${comment}" align="center" prop="quickMark" />
      <el-table-column label="是(1)否(0)" align="center" prop="broker" />
      <el-table-column label="经纪人等级一" align="center" prop="brokerGradeOne" />
      <el-table-column label="经纪人等级二" align="center" prop="brokerGradeTwo" />
      <el-table-column label="经纪人等级三" align="center" prop="brokerGradeThree" />
      <el-table-column label="邀请节点路径" align="center" prop="nodePath" />
      <el-table-column label="银行卡所属行" align="center" prop="nickName" />
      <el-table-column label="微信图片" align="center" prop="payWechat" />
      <el-table-column label="支付宝图片" align="center" prop="payAliay" />
      <el-table-column label="微信姓名" align="center" prop="wechatName" />
      <el-table-column label="支付宝姓名" align="center" prop="aliayName" />
      <el-table-column label="身份证反面" align="center" prop="sideLink" />
      <el-table-column label="身份证正面" align="center" prop="positiveLink" /> -->
      <el-table-column label="高级认证状态" align="center" prop="cardState" width="100">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.otc_card_state" :value="scope.row.cardState"/>
        </template>
      </el-table-column>
      <!-- <el-table-column label="商家昵称" align="center" prop="storeName" />
      <el-table-column label="银行卡姓名" align="center" prop="bankUserName" />
      <el-table-column label="银行卡所属行" align="center" prop="bankName" />
      <el-table-column label="银行卡支行" align="center" prop="bankAddress" />
      <el-table-column label="银行卡号" align="center" prop="bankCard" />
      <el-table-column label="法币是否可用'NORMAL'可用，UNNORMAL 不可用" align="center" prop="fbStatus" /> -->
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
      <!-- <el-table-column label="手持身份证照片" align="center" prop="handLink" /> -->
      <el-table-column label="封号状态" align="center" prop="userStatus">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.t_user_status" :value="scope.row.userStatus"/>
        </template>
      </el-table-column>
      <!-- <el-table-column label="法币配置ID" align="center" prop="oucId" width="100"/> -->
      <el-table-column label="是否控盘" align="center" prop="isControl">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.seconds_bet_control_status" :value="scope.row.isControl"/>
        </template>
      </el-table-column>
      <!-- <el-table-column label="xxx" align="center" prop="isBok" /> -->
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="上次登录IP" align="center" prop="lastLoginIp" width="140">
        <template slot-scope="scope">
          <span v-if="scope.row.lastLoginIp == ''">暂无IP</span>
          <!-- <span v-else>{{scope.row.lastLoginIp.split(",")[0]}}</span> -->
        </template>
      </el-table-column>
      <el-table-column label="注册时间" align="center" prop="createTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createTime) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" fixed="right" width="160" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:member:edit']"
          >修改</el-button>
          <el-dropdown size="mini" @command="(command) => handleCommand(command, scope.row)">
            <span class="el-dropdown-link">
              <i class="el-icon-d-arrow-right el-icon--right"></i>更多
            </span>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item command="handleKop" icon="el-icon-circle-check"
                v-hasPermi="['system:member:kop']">控盘</el-dropdown-item>
              <el-dropdown-item command="handleAbove" icon="el-icon-circle-check"
                v-hasPermi="['system:member:above']">上分</el-dropdown-item>
              <el-dropdown-item command="handleLower" icon="el-icon-circle-check"
                v-hasPermi="['system:member:lower']">下分</el-dropdown-item>
              <el-dropdown-item command="handleRest" icon="el-icon-key"
                v-hasPermi="['system:member:restPwd']">重置密码</el-dropdown-item>
              <el-dropdown-item command="handleRestPay" icon="el-icon-key"
                v-hasPermi="['system:member:restPayPwd']">重置支付密码</el-dropdown-item>
              <el-dropdown-item command="handleRemark" icon="el-icon-circle-check"
                v-hasPermi="['system:member:xgbz']">修改备注</el-dropdown-item>
              <el-dropdown-item command="handleWelMember" icon="el-icon-circle-check"
                v-hasPermi="['system:member:wel']">修改邀请人</el-dropdown-item>
              <el-dropdown-item command="handleWelVested" icon="el-icon-circle-check"
                v-hasPermi="['system:member:vested']">修改归属员工</el-dropdown-item>
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
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改会员对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="800px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="100px">
        <el-form-item label="昵称" prop="nickName">
          <el-input v-model="form.nickName" placeholder="请输入昵称" />
        </el-form-item>
        <el-form-item label="头像" prop="handLink">
          <image-upload v-model="form.handLink"/>
        </el-form-item>
        <el-form-item label="手机号" prop="phone">
          <el-input v-model="form.phone" placeholder="请输入手机号" />
        </el-form-item>
        <el-form-item label="姓名" prop="uname">
          <el-input v-model="form.uname" placeholder="请输入姓名" />
        </el-form-item>
        <el-form-item label="身份证号" prop="cardNo">
          <el-input v-model="form.cardNo" placeholder="请输入身份证号" />
        </el-form-item>
        <el-form-item label="高级认证状态" prop="cardState">
          <el-select v-model="form.cardState" placeholder="请选择高级认证状态">
            <el-option
              v-for="dict in dict.type.otc_card_state"
              :key="dict.value"
              :label="dict.label"
:value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="商家昵称" prop="storeName">
          <el-input v-model="form.storeName" placeholder="请输入商家昵称" />
        </el-form-item>
        <el-form-item label="银行卡姓名" prop="bankUserName">
          <el-input v-model="form.bankUserName" placeholder="请输入银行卡姓名" />
        </el-form-item>
        <el-form-item label="银行卡所属行" prop="bankName">
          <el-input v-model="form.bankName" placeholder="请输入银行卡所属行" />
        </el-form-item>
        <el-form-item label="银行卡支行" prop="bankAddress">
          <el-input v-model="form.bankAddress" placeholder="请输入银行卡支行" />
        </el-form-item>
        <el-form-item label="银行卡号" prop="bankCard">
          <el-input v-model="form.bankCard" placeholder="请输入银行卡号" />
        </el-form-item>
        <el-form-item label="是否是商家" prop="storeState">
          <el-select v-model="form.storeState" placeholder="请选择是否是商家">
            <el-option
              v-for="dict in dict.type.otc_store_state"
              :key="dict.value"
              :label="dict.label"
:value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <!-- <el-form-item label="密码盐" prop="salt">
          <el-input v-model="form.salt" placeholder="请输入密码盐" />
        </el-form-item> -->
        <el-form-item label="区号" prop="areaCode">
          <el-select v-model="form.areaCode" placeholder="请选择区号">
            <el-option
              v-for="dict in dict.type.area_info"
              :key="dict.value"
              :label="dict.label"
:value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <!-- <el-form-item label="手持身份证照片" prop="handLink">
          <el-input v-model="form.handLink" placeholder="请输入手持身份证照片" />
        </el-form-item> -->
        <el-form-item label="封号状态" prop="userStatus">
          <el-select v-model="form.userStatus" placeholder="请选择封号状态">
            <el-option
              v-for="dict in dict.type.t_user_status"
              :key="dict.value"
              :label="dict.label"
:value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="会员类型" prop="useType">
          <el-select v-model="form.useType" placeholder="请选择会员类型">
            <el-option
              v-for="dict in dict.type.member_zh_type"
              :key="dict.value"
              :label="dict.label"
:value="parseInt(dict.value)"
            ></el-option>
          </el-select>
        </el-form-item>
        <!-- <el-form-item label="法币配置ID" prop="oucId">
          <el-input v-model="form.oucId" placeholder="请输入法币配置ID" />
        </el-form-item>
        <el-form-item label="是否控盘" prop="isControl">
          <el-select v-model="form.isControl" placeholder="请选择是否控盘">
            <el-option
              v-for="dict in dict.type.seconds_bet_control_status"
              :key="dict.value"
              :label="dict.label"
:value="parseInt(dict.value)"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="xxx" prop="isBok">
          <el-input v-model="form.isBok" placeholder="请输入xxx" />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" placeholder="请输入备注" />
        </el-form-item> -->
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
    <!-- 控盘 -->
    <el-dialog title="是否控盘" :visible.sync="open2" width="350px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="是否控盘" prop="isControl">
          <el-select v-model="form.isControl" placeholder="请选择是否控盘">
            <el-option
              v-for="dict in dict.type.seconds_bet_control_status"
              :key="dict.value"
              :label="dict.label"
:value="parseInt(dict.value)"
            ></el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm2">确 定</el-button>
        <el-button @click="cancel2">取 消</el-button>
      </div>
    </el-dialog>
    <!-- 修改备注 -->
    <el-dialog title="修改备注" :visible.sync="open3" width="350px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="50px">
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" placeholder="请输入备注" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm3">确 定</el-button>
        <el-button @click="open3 = false">取 消</el-button>
      </div>
    </el-dialog>

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
        <!-- <el-table-column label="冻结余额" align="center" prop="blockedBalance" />
        <el-table-column label="币币余额" align="center" prop="balance" /> -->
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
        <!-- <el-table-column label="合约可用" align="center" prop="tokenBalance" />
        <el-table-column label="合约冻结" align="center" prop="tokenBlockedBalance" />
        <el-table-column label="法币可用" align="center" prop="fbBalance" />
        <el-table-column label="法币冻结" align="center" prop="fbBlockedBalance" />
        <el-table-column label="私募冻结" align="center" prop="raiseBalance" />
        <el-table-column label="恋上资产" align="center" prop="chainBalance" /> -->
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
        <el-table-column label="佣金" align="center" prop="brokerage" /> -->
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

      <!-- 查看IP -->
    <el-dialog title="查看IP" :visible.sync="ipOpen" width="500px" append-to-body>
      <el-row>
        <el-col :span="6" align="center" v-for="(item,index) in ipList" :key="index">{{item}}</el-col>
      </el-row>

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

    <el-dialog v-loading="loadingSF" title="会员上分" :visible.sync="upStatus" width="500px" append-to-body>
      <el-form ref="mudForm" :model="mud" :rules="mudRules" label-width="80px">
        <el-form-item label="币种" prop="currency">
          <el-select v-model="mud.currency" placeholder="请选择币种">
            <el-option
              v-for="dict in dict.type.ud_score_bf"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="金额" prop="amount">
          <el-input v-model="mud.amount" placeholder="请输入金额" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="upSubmitForm">确 定</el-button>
        <el-button @click="upCancel">取 消</el-button>
      </div>
    </el-dialog>

    <el-dialog v-loading="loadingXF" title="会员下分" :visible.sync="downStatus" width="500px" append-to-body>
      <el-form ref="mudForm" :model="mud" :rules="mudRules" label-width="80px">
        <el-form-item label="币种" prop="currency">
          <el-select v-model="mud.currency" placeholder="请选择币种">
            <el-option
              v-for="dict in dict.type.ud_score_bf"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="金额" prop="amount">
          <el-input v-model="mud.amount" placeholder="请输入金额" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="downSubmitForm">确 定</el-button>
        <el-button @click="downCancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listMember, getMember, delMember, addMember, updateMember,Above,Lower,RsetPwd,getZCMS,
upWelMember,upVested,finPList,RsetPayPwd } from "@/api/system/member";
import { checkOperPwd} from "@/api/census";
import { listBalanceRecord} from "@/api/system/balanceRecord";
import redirectVue from '../../redirect.vue';
export default {
  name: "Member",
  dicts: ['area_info', 't_user_status', 'seconds_bet_control_status', 'otc_store_state', 'otc_card_state','member_zh_type','amount_change_type','ud_score_bf'],
  data() {
    return {
      upStatus:false,
      downStatus:false,
      mud:{
        id:null,
        currency:null,
        amount:null,
      },
      mudRules: {
        currency: [
          { required: true, message: "币种不能为空", trigger: "blur" }
        ],
        amount: [
          { required: true, message: "金额不能为空", trigger: "blur" }
        ],
      },
      ipOpen: false,
      ipList: [],
      // 遮罩层
      loading: true,
      loadingSF: false,
      loadingXF: false,
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
      // 会员表格数据
      memberList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        phone: null,
        uuid: null,
        mail: null,
        password: null,
        welMember: null,
        brokerage: null,
        welCode: null,
        payPassword: null,
        type: null,
        uname: null,
        sex: null,
        birth: null,
        cardNo: null,
        address: null,
        quickMark: null,
        broker: null,
        brokerGradeOne: null,
        brokerGradeTwo: null,
        brokerGradeThree: null,
        nodePath: null,
        nickName: null,
        payWechat: null,
        payAliay: null,
        wechatName: null,
        aliayName: null,
        sideLink: null,
        positiveLink: null,
        cardState: null,
        storeName: null,
        bankUserName: null,
        bankName: null,
        bankAddress: null,
        bankCard: null,
        fbStatus: null,
        storeState: null,
        salt: null,
        areaCode: null,
        handLink: null,
        userStatus: null,
        oucId: null,
        isControl: null,
        isBok: null,
        useType: null,
        welMemberUuid:null,
        welMemberPhone:null,
        sysId:null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        brokerage: [
          { required: true, message: "佣金不能为空", trigger: "blur" }
        ],
        broker: [
          { required: true, message: "是(1)否(0)不能为空", trigger: "blur" }
        ],
        brokerGradeOne: [
          { required: true, message: "经纪人等级一不能为空", trigger: "blur" }
        ],
        brokerGradeTwo: [
          { required: true, message: "经纪人等级二不能为空", trigger: "blur" }
        ],
        brokerGradeThree: [
          { required: true, message: "经纪人等级三不能为空", trigger: "blur" }
        ],
        areaCode: [
          { required: true, message: "区号不能为空", trigger: "change" }
        ],
        isControl: [
          { required: true, message: "是否控盘不能为空", trigger: "change" }
        ],
      },
      open2:false,
      open3:false,
      balanceList: [],
      queryParams2: {
        pageNum: 1,
        pageSize: 10,
        userId: null,
      },
      open4:false,
      open5:false,
      open8:false,
      downMemberList:[],
      qbAmount:"",
      qbFreeze:"",
      queryParams3: {
        pageNum: 1,
        pageSize: 10,
        memberId: null,
      },
      balanceRecordList:[],
      total3:0,
    };
  },
  computed: {
      pathImg() {
        return localStorage.getItem('imgPath')
      }
    },
  created() {
    this.getList();
  },
  methods: {
    /**
     * 查看IP列
     */
    lookIpList(row){
      // if(row.lastLoginIp != ''){
      //   this.ipOpen = true;
      //   this.ipList = row.lastLoginIp.split(",")
      // }else{
      //   this.$message.error('暂无IP记录');
      // }
    },
    // 更多操作触发
    handleCommand(command, row) {
      switch (command) {
        case "handleKop":
          this.handleKop(row);
          break;
        case "handleAbove":
          this.handleAbove(row);
          break;
        case "handleLower":
          this.handleLower(row);
          break;
        case "handleRest":
          this.handleRest(row);
          break;
        case "handleRestPay":
          this.handleRestPay(row);
          break;
        case "handleRemark":
          this.handleRemark(row);
          break;
        case "handleWelMember":
          this.handleWelMember(row);
          break;
        case "handleWelVested":
          this.handleWelVested(row);
          break;
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
    /** 查询会员列表 */
    getList() {
      this.loading = true;
      listMember(this.queryParams).then(response => {
        console.log(this.memberList)
        this.memberList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    cancel2(){
      this.open2 = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        phone: null,
        uuid: null,
        mail: null,
        password: null,
        welMember: null,
        brokerage: null,
        welCode: null,
        payPassword: null,
        type: null,
        uname: null,
        sex: null,
        birth: null,
        cardNo: null,
        address: null,
        quickMark: null,
        broker: null,
        brokerGradeOne: null,
        brokerGradeTwo: null,
        brokerGradeThree: null,
        nodePath: null,
        nickName: null,
        payWechat: null,
        payAliay: null,
        wechatName: null,
        aliayName: null,
        sideLink: null,
        positiveLink: null,
        cardState: null,
        createTime: null,
        updateTime: null,
        storeName: null,
        bankUserName: null,
        bankName: null,
        bankAddress: null,
        bankCard: null,
        fbStatus: null,
        storeState: null,
        salt: null,
        areaCode: null,
        handLink: null,
        userStatus: null,
        oucId: null,
        isControl: null,
        isBok: null,
        remark: null,
        useType: null,
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
      this.title = "添加会员";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      console.log(row)
      this.reset();
      const id = row.id || this.ids
      getMember(id).then(response => {
        this.form = response.data;
        this.form = row;
        this.open = true;
        this.title = "修改会员";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateMember(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addMember(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除会员编号为"' + ids + '"的数据项？').then(function() {
        return delMember(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/member/export', {
        ...this.queryParams
      }, `member_${new Date().getTime()}.xlsx`)
    },
    //控盘
    handleKop(row){
      this.reset();
      const id = row.id || this.ids
      getMember(id).then(response => {
        this.form = response.data;
        this.open2 = true;
      });
    },
      /** 控盘提交 */
    submitForm2() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateMember(this.form).then(response => {
              this.$modal.msgSuccess("操作成功");
              this.open2 = false;
              this.getList();
            });
          } else {
            addMember(this.form).then(response => {
              this.$modal.msgSuccess("操作成功");
              this.open2 = false;
              this.getList();
            });
          }
        }
      });
    },
    //修改备注
    handleRemark(row){
      this.reset();
      const id = row.id || this.ids
      getMember(id).then(response => {
        this.form = response.data;
        this.open3 = true;
      });
    },
      /** 修改备注提交 */
    submitForm3() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateMember(this.form).then(response => {
              this.$modal.msgSuccess("操作成功");
              this.open3 = false;
              this.getList();
            });
          } else {
            addMember(this.form).then(response => {
              this.$modal.msgSuccess("操作成功");
              this.open3 = false;
              this.getList();
            });
          }
        }
      });
    },

    //上分
    handleAbove(row){
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
            this.upStatus = true;
            this.mud.id = row.id;
            // this.$modal.msgSuccess("验证成功");
            // this.$prompt('请输入该会员需要上分数额', "提示", {
            //   confirmButtonText: "确定",
            //   cancelButtonText: "取消",
            //   closeOnClickModal: false,
            // }).then(({ value }) => {
            //   let obj = new Object();
            //   obj.id = row.id;
            //   obj.amount = value;
            //   Above(obj).then(res=>{
            //     this.$modal.msgSuccess("操作成功");
            //     this.getList();
            //   })
            // }).catch(() => {});
          }
        })
      }).catch(() => {});

    },
    //下分
    handleLower(row){
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
            this.downStatus = true;
            this.mud.id = row.id;
            // this.$prompt('请输入该会员需要下分数额', "提示", {
            //   confirmButtonText: "确定",
            //   cancelButtonText: "取消",
            //   closeOnClickModal: false,
            // }).then(({ value }) => {
            //   let obj = new Object();
            //   obj.id = row.id;
            //   obj.amount = value;
            //   Lower(obj).then(res=>{
            //     this.$modal.msgSuccess("操作成功");
            //     this.getList();
            //   })
            // }).catch(() => {});
          }
        })
      }).catch(() => {});

    },
    //上分确定
    upSubmitForm(){
      this.loadingSF = true;
      this.$refs["mudForm"].validate(valid => {
        if (valid) {
          console.log(this.mud)
          Above(this.mud).then(res=>{
            this.$modal.msgSuccess("操作成功");
            this.upStatus = false;
            this.loadingSF = false;
            this.getList();
          })
        }
      });
    },
    //上分取消
    upCancel(){
      this.upStatus = false;
      this.$refs['mudForm'].resetFields();
      this.mud = {
        id:null,
        currency:null,
        amount:null,
      }
    },
    //下分确定
    downSubmitForm(){
      this.loadingXF = true;
      this.$refs["mudForm"].validate(valid => {
        if (valid) {
          console.log(this.mud)
          Lower(this.mud).then(res=>{
            this.$modal.msgSuccess("操作成功");
            this.downStatus = false;
            this.loadingXF = false;
            this.getList();
          })
        }
      });
    },
    //下分取消
    downCancel(){
      this.downStatus = false;
      this.$refs['mudForm'].resetFields();
      this.mud = {
        id:null,
        currency:null,
        amount:null,
      }
    },


    //重置密码
    handleRest(row){
      this.$prompt('请输入该会员需要设定的密码', "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        closeOnClickModal: false,
      }).then(({ value }) => {
        let obj = new Object();
        obj.id = row.id;
        obj.password = this.$md5(value);
        RsetPwd(obj).then(res=>{
          this.$modal.msgSuccess("操作成功");
          this.getList();
        })
      }).catch(() => {});
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
      // this.queryParams2.userId = row.id;
      // this.open4 = true;
      // this.getBalanceList();
    },
    //修改邀请人
    handleWelMember(row){
       this.$prompt('请输入邀请人的UUID', "温馨提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        closeOnClickModal: false,
      }).then(({ value }) => {
        let obj = new Object();
        obj.id = row.id;
        obj.uuid = value
        upWelMember(obj).then(res=>{
          this.$modal.msgSuccess("操作成功");
          this.getList();
        })
      }).catch(() => {});
    },
    //修改归属员工
    handleWelVested(row){
      this.$prompt('请输入后台对应的员工ID', "温馨提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        closeOnClickModal: false,
      }).then(({ value }) => {
        let obj = new Object();
        obj.id = row.id;
        obj.sysId = value
        upVested(obj).then(res=>{
          this.$modal.msgSuccess("操作成功");
          this.getList();
        })
      }).catch(() => {});
    },
    //查看下级
    handlePid(row){
      finPList(row.id).then(res=>{
        console.log(res.data)
        this.downMemberList = res.data
        this.open5 = true;
      })
    },
    //重置支付密码
    handleRestPay(row){
      this.$prompt('请输入该会员需要设定的支付密码', "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        closeOnClickModal: false,
      }).then(({ value }) => {
        let obj = new Object();
        obj.id = row.id;
        obj.password = this.$md5(value);
        RsetPayPwd(obj).then(res=>{
          this.$modal.msgSuccess("操作成功");
          this.getList();
        })
      }).catch(() => {});
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
  }
};
</script>

<style scoped lang="scss">
.link{
  height: 20px;
}
</style>
