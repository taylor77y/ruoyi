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
      <!-- <el-form-item label="邀请人id" prop="welMember">
        <el-input
          v-model="queryParams.welMember"
          placeholder="请输入邀请人id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
      <!-- <el-form-item label="佣金" prop="brokerage">
        <el-input
          v-model="queryParams.brokerage"
          placeholder="请输入佣金"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
      <!-- <el-form-item label="邀请码" prop="welCode">
        <el-input
          v-model="queryParams.welCode"
          placeholder="请输入邀请码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
      <!-- <el-form-item label="支付密码" prop="payPassword">
        <el-input
          v-model="queryParams.payPassword"
          placeholder="请输入支付密码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
      <!-- <el-form-item label="姓名" prop="uname">
        <el-input
          v-model="queryParams.uname"
          placeholder="请输入姓名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
      <!-- <el-form-item label="出生日期" prop="birth">
        <el-input
          v-model="queryParams.birth"
          placeholder="请输入出生日期"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
      <!-- <el-form-item label="身份证号" prop="cardNo">
        <el-input
          v-model="queryParams.cardNo"
          placeholder="请输入身份证号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
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
      <!-- <el-form-item label="高级认证状态" prop="cardState">
        <el-select v-model="queryParams.cardState" placeholder="请选择高级认证状态" clearable>
          <el-option
            v-for="dict in dict.type.otc_card_state"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item> -->
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
      <!-- <el-form-item label="是否是商家" prop="storeState">
        <el-select v-model="queryParams.storeState" placeholder="请选择是否是商家" clearable>
          <el-option
            v-for="dict in dict.type.otc_store_state"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item> -->
      <!-- <el-form-item label="区号" prop="areaCode">
        <el-select v-model="queryParams.areaCode" placeholder="请选择区号" clearable>
          <el-option
            v-for="dict in dict.type.area_info"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item> -->
      <!-- <el-form-item label="手持身份证照片" prop="handLink">
        <el-input
          v-model="queryParams.handLink"
          placeholder="请输入手持身份证照片"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
      <!-- <el-form-item label="封号状态" prop="userStatus">
        <el-select v-model="queryParams.userStatus" placeholder="请选择封号状态" clearable>
          <el-option
            v-for="dict in dict.type.t_user_status"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item> -->
      <!-- <el-form-item label="法币配置ID" prop="oucId">
        <el-input
          v-model="queryParams.oucId"
          placeholder="请输入法币配置ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
      <!-- <el-form-item label="是否控盘" prop="isControl">
        <el-select v-model="queryParams.isControl" placeholder="请选择是否控盘" clearable>
          <el-option
            v-for="dict in dict.type.seconds_bet_control_status"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item> -->
      <!-- <el-form-item label="xxx" prop="isBok">
        <el-input
          v-model="queryParams.isBok"
          placeholder="请输入xxx"
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
          v-hasPermi="['system:store:add']"
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
          v-hasPermi="['system:store:edit']"
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
          v-hasPermi="['system:store:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:store:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="memberList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <!-- <el-table-column label="ID" align="center" prop="id" width="300"/> -->
      <el-table-column label="手机号" align="center" prop="phone" width="100"/>
      <el-table-column label="UUID" align="center" prop="uuid" width="100"/>
      <el-table-column label="邮箱" align="center" prop="mail" width="200"/>
      <!-- <el-table-column label="登录密码" align="center" prop="password" /> -->
      <!-- <el-table-column label="邀请人id" align="center" prop="welMember" />
      <el-table-column label="佣金" align="center" prop="brokerage" /> -->
      <!-- <el-table-column label="邀请码" align="center" prop="welCode" /> -->
      <!-- <el-table-column label="支付密码" align="center" prop="payPassword" />
      <el-table-column label="账号类型:INTERNAL内部的,EXTERNAL外部的" align="center" prop="type" /> -->
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
      <!-- <el-table-column label="高级认证状态" align="center" prop="cardState" width="100">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.otc_card_state" :value="scope.row.cardState"/>
        </template>
      </el-table-column> -->
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
      <!-- <el-table-column label="区号" align="center" prop="areaCode" width="100">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.area_info" :value="scope.row.areaCode"/>
        </template>
      </el-table-column> -->
      <!-- <el-table-column label="手持身份证照片" align="center" prop="handLink" /> -->
      <!-- <el-table-column label="封号状态" align="center" prop="userStatus">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.t_user_status" :value="scope.row.userStatus"/>
        </template>
      </el-table-column> -->
      <el-table-column label="法币配置" align="center" prop="oucName" width="100"/>
      <!-- <el-table-column label="客服链接" align="center" prop="connectLink" width="100" fixed="right">
        <template slot-scope="scope">
          <el-link type="primary" :underline="false" :href="scope.row.connectLink">进入客服</el-link>
        </template>
      </el-table-column> -->
      <!-- <el-table-column label="xxx" align="center" prop="isBok" /> -->
      <!-- <el-table-column label="备注" align="center" prop="remark" /> -->
      <!-- <el-table-column label="注册时间" align="center" prop="createTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createTime) }}</span>
        </template>
      </el-table-column> -->
      <el-table-column label="操作" align="center" fixed="right" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:store:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:store:remove']"
          >删除</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-money"
            @click="handleFbBalance(scope.row)"
            v-hasPermi="['system:store:fbAmount']"
          >充值余额</el-button>
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
        <el-form-item label="手机号" prop="phone">
          <el-input v-model="form.phone" placeholder="请输入手机号" />
        </el-form-item>
        <!-- <el-form-item label="UUID" prop="uuid">
          <el-input v-model="form.uuid" placeholder="请输入UUID" />
        </el-form-item> -->
        <el-form-item label="邮箱" prop="mail">
          <el-input v-model="form.mail" placeholder="请输入邮箱" />
        </el-form-item>
        <!-- <el-form-item label="登录密码" prop="password">
          <el-input v-model="form.password" placeholder="请输入登录密码" />
        </el-form-item> -->
        <!-- <el-form-item label="邀请人id" prop="welMember">
          <el-input v-model="form.welMember" placeholder="请输入邀请人id" />
        </el-form-item>
        <el-form-item label="佣金" prop="brokerage">
          <el-input v-model="form.brokerage" placeholder="请输入佣金" />
        </el-form-item>
        <el-form-item label="邀请码" prop="welCode">
          <el-input v-model="form.welCode" placeholder="请输入邀请码" />
        </el-form-item>
        <el-form-item label="支付密码" prop="payPassword">
          <el-input v-model="form.payPassword" placeholder="请输入支付密码" />
        </el-form-item> -->
        <el-form-item label="姓名" prop="uname">
          <el-input v-model="form.uname" placeholder="请输入姓名" />
        </el-form-item>
        <!-- <el-form-item label="出生日期" prop="birth">
          <el-input v-model="form.birth" placeholder="请输入出生日期" />
        </el-form-item> -->
        <!-- <el-form-item label="身份证号" prop="cardNo">
          <el-input v-model="form.cardNo" placeholder="请输入身份证号" />
        </el-form-item> -->
        <!-- <el-form-item label="${comment}" prop="address">
          <el-input v-model="form.address" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="quickMark">
          <el-input v-model="form.quickMark" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="是(1)否(0)" prop="broker">
          <el-input v-model="form.broker" placeholder="请输入是(1)否(0)" />
        </el-form-item>
        <el-form-item label="经纪人等级一" prop="brokerGradeOne">
          <el-input v-model="form.brokerGradeOne" placeholder="请输入经纪人等级一" />
        </el-form-item>
        <el-form-item label="经纪人等级二" prop="brokerGradeTwo">
          <el-input v-model="form.brokerGradeTwo" placeholder="请输入经纪人等级二" />
        </el-form-item>
        <el-form-item label="经纪人等级三" prop="brokerGradeThree">
          <el-input v-model="form.brokerGradeThree" placeholder="请输入经纪人等级三" />
        </el-form-item>
        <el-form-item label="邀请节点路径" prop="nodePath">
          <el-input v-model="form.nodePath" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="银行卡所属行" prop="nickName">
          <el-input v-model="form.nickName" placeholder="请输入银行卡所属行" />
        </el-form-item>
        <el-form-item label="微信图片" prop="payWechat">
          <el-input v-model="form.payWechat" placeholder="请输入微信图片" />
        </el-form-item>
        <el-form-item label="支付宝图片" prop="payAliay">
          <el-input v-model="form.payAliay" placeholder="请输入支付宝图片" />
        </el-form-item>
        <el-form-item label="微信姓名" prop="wechatName">
          <el-input v-model="form.wechatName" placeholder="请输入微信姓名" />
        </el-form-item>
        <el-form-item label="支付宝姓名" prop="aliayName">
          <el-input v-model="form.aliayName" placeholder="请输入支付宝姓名" />
        </el-form-item>
        <el-form-item label="身份证反面" prop="sideLink">
          <el-input v-model="form.sideLink" placeholder="请输入身份证反面" />
        </el-form-item>
        <el-form-item label="身份证正面" prop="positiveLink">
          <el-input v-model="form.positiveLink" placeholder="请输入身份证正面" />
        </el-form-item> -->
        <!-- <el-form-item label="高级认证状态" prop="cardState">
          <el-select v-model="form.cardState" placeholder="请选择高级认证状态">
            <el-option
              v-for="dict in dict.type.otc_card_state"
              :key="dict.value"
              :label="dict.label"
:value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item> -->
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
        <!-- <el-form-item label="是否是商家" prop="storeState">
          <el-select v-model="form.storeState" placeholder="请选择是否是商家">
            <el-option
              v-for="dict in dict.type.otc_store_state"
              :key="dict.value"
              :label="dict.label"
:value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item> -->
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
        <!-- <el-form-item label="封号状态" prop="userStatus">
          <el-select v-model="form.userStatus" placeholder="请选择封号状态">
            <el-option
              v-for="dict in dict.type.t_user_status"
              :key="dict.value"
              :label="dict.label"
:value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item> -->
        <el-form-item label="法币配置" prop="oucId">
          <el-select v-model="form.oucId" placeholder="请选择法币配置">
            <el-option
              v-for="dict in fbList"
              :key="dict.id"
              :label="dict.currencyName"
              :value="parseInt(dict.id)"
            ></el-option>
          </el-select>
        </el-form-item>
        <!-- <el-form-item label="是否控盘" prop="isControl">
          <el-select v-model="form.isControl" placeholder="请选择是否控盘">
            <el-option
              v-for="dict in dict.type.seconds_bet_control_status"
              :key="dict.value"
              :label="dict.label"
:value="parseInt(dict.value)"
            ></el-option>
          </el-select>
        </el-form-item> -->
        <!-- <el-form-item label="xxx" prop="isBok">
          <el-input v-model="form.isBok" placeholder="请输入xxx" />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" placeholder="请输入备注" />
        </el-form-item> -->
        <el-form-item label="客服链接" prop="connectLink">
          <el-input type="textarea" v-model="form.connectLink" placeholder="请输入客服链接" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>

    <!-- 充值法币余额 -->
  </div>
</template>

<script>
import { listMember, getMember, delMember, addMember, updateMember,oucList,fbAmount } from "@/api/system/store";
export default {
  name: "Member",
  dicts: ['area_info', 't_user_status', 'seconds_bet_control_status', 'otc_store_state', 'otc_card_state'],
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
      fbList:[],
      value:'0000'
    };
  },
  created() {
    this.getList();
    this.getFB();
  },
  methods: {
    /** 查询会员列表 */
    getList() {
      this.loading = true;
      listMember(this.queryParams).then(response => {
        this.memberList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    getFB(){
      oucList().then(res=>{
        this.fbList = res.data
      })
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
        remark: null
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
      this.title = "添加OTC商户";
      this.form.password = this.$md5('1111');
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      this.getFB();
      const id = row.id || this.ids
      getMember(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改OTC商户";
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
    //法币充值
    handleFbBalance(row){
      this.$prompt('请输入需要充值的法币数额', "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        closeOnClickModal: false,
      }).then(({ value }) => {
        let obj = new Object();
        obj.id = row.id;
        obj.amount = value;
        fbAmount(obj).then(res=>{
          this.$modal.msgSuccess("操作成功");
          this.getList();
        })
      }).catch(() => {});
    }
  }
};
</script>
