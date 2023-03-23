<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="88px">
      <el-form-item label="交易对名称" prop="pairsName">
        <el-input v-model="queryParams.pairsName" placeholder="请输入交易对名称" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <!-- <el-form-item label="主币" prop="mainCur">
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
      <el-form-item label="冻结状态" prop="state">
        <el-select v-model="queryParams.state" placeholder="请选择冻结状态" clearable>
          <el-option v-for="dict in dict.type.t_pair_status" :key="dict.value" :label="dict.label"
                     :value="dict.value"/>
        </el-select>
      </el-form-item>
      <el-form-item label="类型" prop="type">
        <el-select v-model="queryParams.type" placeholder="请选择类型" clearable>
          <el-option v-for="dict in dict.type.t_pair_type" :key="dict.value" :label="dict.label" :value="dict.value"/>
        </el-select>
      </el-form-item>
      <!-- <el-form-item label="合约地址" prop="contract">
        <el-input
          v-model="queryParams.contract"
          placeholder="请输入合约地址"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="合约小数位" prop="point">
        <el-input
          v-model="queryParams.point"
          placeholder="请输入合约小数位"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
      <!-- <el-form-item label="排序" prop="sort">
        <el-input
          v-model="queryParams.sort"
          placeholder="请输入排序"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="开盘价" prop="openPrice">
        <el-input
          v-model="queryParams.openPrice"
          placeholder="请输入开盘价"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="现价" prop="price">
        <el-input
          v-model="queryParams.price"
          placeholder="请输入现价"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="chPrice">
        <el-input
          v-model="queryParams.chPrice"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="volume">
        <el-input
          v-model="queryParams.volume"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="open">
        <el-input
          v-model="queryParams.open"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="lowPrice">
        <el-input
          v-model="queryParams.lowPrice"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="higPrice">
        <el-input
          v-model="queryParams.higPrice"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="updown">
        <el-input
          v-model="queryParams.updown"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
      <el-form-item label="是否推荐" prop="isTop">
        <el-select v-model="queryParams.isTop" placeholder="请选择是否推荐" clearable>
          <el-option v-for="dict in dict.type.shifou" :key="dict.value" :label="dict.label" :value="dict.value"/>
        </el-select>
      </el-form-item>
      <!-- <el-form-item label="最大交易数量" prop="tradeMax">
        <el-input
          v-model="queryParams.tradeMax"
          placeholder="请输入最大交易数量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="最小交易数量" prop="tradeMin">
        <el-input
          v-model="queryParams.tradeMin"
          placeholder="请输入最小交易数量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
      <el-form-item label="币币" prop="tradeType">
        <el-select v-model="queryParams.tradeType" placeholder="请选择币币" clearable>
          <el-option v-for="dict in dict.type.tradeType" :key="dict.value" :label="dict.label" :value="dict.value"/>
        </el-select>
      </el-form-item>
      <!-- <el-form-item label="交易手续费" prop="tradeRate">
        <el-input
          v-model="queryParams.tradeRate"
          placeholder="请输入交易手续费"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
      <el-form-item label="主链" prop="mainFrom">
        <el-select v-model="queryParams.mainFrom" placeholder="请选择主链" clearable>
          <el-option v-for="dict in dict.type.zp_type" :key="dict.value" :label="dict.label" :value="dict.value"/>
        </el-select>
      </el-form-item>
      <el-form-item label="充提开关" prop="isDw">
        <el-select v-model="queryParams.isDw" placeholder="请选择充提开关" clearable>
          <el-option v-for="dict in dict.type.isdw" :key="dict.value" :label="dict.label" :value="dict.value"/>
        </el-select>
      </el-form-item>
      <!-- <el-form-item label="最提币数量" prop="withdrawMin">
        <el-input
          v-model="queryParams.withdrawMin"
          placeholder="请输入最提币数量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="提币手续费" prop="withdrawFee">
        <el-input
          v-model="queryParams.withdrawFee"
          placeholder="请输入提币手续费"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
      <el-form-item label="币类型" prop="pairsType">
        <el-select v-model="queryParams.pairsType" placeholder="请选择币类型" clearable>
          <el-option v-for="dict in dict.type.pair_type_su" :key="dict.value" :label="dict.label" :value="dict.value"/>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button type="primary" plain icon="el-icon-plus" size="mini" @click="handleAdd"
                   v-hasPermi="['system:pairs:add']">新增
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="success" plain icon="el-icon-edit" size="mini" :disabled="single" @click="handleUpdate"
                   v-hasPermi="['system:pairs:edit']">修改
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="danger" plain icon="el-icon-delete" size="mini" :disabled="multiple" @click="handleDelete"
                   v-hasPermi="['system:pairs:remove']">删除
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport"
                   v-hasPermi="['system:pairs:export']">导出
        </el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="pairsList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center"/>
      <!-- <el-table-column label="ID" align="center" prop="id" /> -->
      <el-table-column label="交易对名称" align="center" prop="pairsName"/>
      <el-table-column label="主币" align="center" prop="mainCur"/>
      <el-table-column label="代币" align="center" prop="tokenCur"/>
      <el-table-column label="冻结状态" align="center" prop="state">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.t_pair_status" :value="scope.row.state"/>
        </template>
      </el-table-column>
      <el-table-column label="类型" align="center" prop="type">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.t_pair_type" :value="scope.row.type"/>
        </template>
      </el-table-column>
      <el-table-column label="币类型" align="center" prop="pairsType">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.pair_type_su" :value="scope.row.pairsType"/>
        </template>
      </el-table-column>
      <!-- <el-table-column label="合约地址" align="center" prop="contract" />
      <el-table-column label="合约小数位" align="center" prop="point" />
      <el-table-column label="LOGO" align="center" prop="image" width="100">
        <template slot-scope="scope">
          <image-preview :src="scope.row.image" :width="50" :height="50"/>
        </template>
      </el-table-column> -->
      <el-table-column label="LOGO" align="center" prop="image" width="100">
        <template slot-scope="scope">
          <image-preview :src="scope.row.image" :width="50" :height="50"/>
        </template>
      </el-table-column>
      <el-table-column label="排序" align="center" prop="sort"/>
      <el-table-column label="开盘价" align="center" prop="openPrice"/>
      <el-table-column label="现价" align="center" prop="price"/>
      <!-- <el-table-column label="${comment}" align="center" prop="chPrice" />
      <el-table-column label="${comment}" align="center" prop="volume" />
      <el-table-column label="${comment}" align="center" prop="open" />
      <el-table-column label="${comment}" align="center" prop="lowPrice" />
      <el-table-column label="${comment}" align="center" prop="higPrice" />
      <el-table-column label="${comment}" align="center" prop="updown" /> -->
      <el-table-column label="是否推荐" align="center" prop="isTop">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.shifou" :value="scope.row.isTop"/>
        </template>
      </el-table-column>
      <el-table-column label="最大交易数量" align="center" prop="tradeMax"/>
      <el-table-column label="最小交易数量" align="center" prop="tradeMin"/>
      <!-- <el-table-column label="最提币数量" align="center" prop="withdrawMin" /> -->
      <el-table-column label="提币手续费" align="center" prop="withdrawFee"/>
      <el-table-column label="交易手续费" align="center" prop="tradeRate"/>
      <el-table-column label="开启交易" align="center" prop="tradeType">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.tradeType" :value="scope.row.tradeType"/>
        </template>
      </el-table-column>
      <el-table-column label="充提开关" align="center" prop="isDw">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.isdw" :value="scope.row.isDw"/>
        </template>
      </el-table-column>
      <el-table-column label="主链" align="center" prop="mainFrom">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.zp_type" :value="scope.row.mainFrom"/>
        </template>
      </el-table-column>
      <el-table-column label="创建时间" align="center" prop="createTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createTime) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" width="200" class-name="small-padding fixed-width" fixed="right">
        <template slot-scope="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
                     v-hasPermi="['system:pairs:edit']">修改
          </el-button>

          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
                     v-hasPermi="['system:pairs:remove']">删除
          </el-button>
          <el-button size="mini" v-if="scope.row.pairsType === 2" type="text" icon="el-icon-edit"
                     @click="handleSee(scope.row)"
                     v-hasPermi="['system:pairs:edit']">控盘
          </el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination v-show="total>0" :total="total" :page.sync="queryParams.pageNum" :limit.sync="queryParams.pageSize"
                @pagination="getList"/>

    <!-- 添加或修改交易对配置对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="800px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="100px">
        <el-form-item label="交易对名称" prop="pairsName">
          <el-input v-model="form.pairsName" placeholder="请输入交易对名称"/>
        </el-form-item>
        <el-form-item label="主币" prop="mainCur">
          <el-input v-model="form.mainCur" placeholder="请输入主币"/>
        </el-form-item>
        <el-form-item label="代币" prop="tokenCur">
          <el-input v-model="form.tokenCur" placeholder="请输入代币"/>
        </el-form-item>
        <el-form-item label="冻结状态" prop="state">
          <el-select v-model="form.state" placeholder="请选择冻结状态">
            <el-option v-for="dict in dict.type.t_pair_status" :key="dict.value" :label="dict.label"
                       :value="dict.value"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="类型" prop="type">
          <el-select v-model="form.type" placeholder="请选择类型">
            <el-option v-for="dict in dict.type.t_pair_type" :key="dict.value" :label="dict.label" :value="dict.value">
            </el-option>
          </el-select>
        </el-form-item>
        <!-- <el-form-item label="合约地址" prop="contract">
          <el-input v-model="form.contract" placeholder="请输入合约地址" />
        </el-form-item>
        <el-form-item label="合约小数位" prop="point">
          <el-input v-model="form.point" placeholder="请输入合约小数位" />
        </el-form-item>
        <el-form-item label="LOGO">
          <image-upload v-model="form.image"/>
        </el-form-item> -->
        <el-form-item label="LOGO">
          <image-upload v-model="form.image"/>
        </el-form-item>
        <el-form-item label="排序" prop="sort">
          <el-input v-model="form.sort" placeholder="请输入排序"/>
        </el-form-item>
        <el-form-item label="开盘价" prop="openPrice">
          <el-input v-model="form.openPrice" placeholder="请输入开盘价"/>
        </el-form-item>
        <el-form-item label="现价" prop="price">
          <el-input v-model="form.price" placeholder="请输入现价"/>
        </el-form-item>
        <!-- <el-form-item label="${comment}" prop="chPrice">
          <el-input v-model="form.chPrice" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="volume">
          <el-input v-model="form.volume" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="open">
          <el-input v-model="form.open" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="lowPrice">
          <el-input v-model="form.lowPrice" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="higPrice">
          <el-input v-model="form.higPrice" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="updown">
          <el-input v-model="form.updown" placeholder="请输入${comment}" />
        </el-form-item> -->
        <el-form-item label="是否推荐" prop="isTop">
          <el-select v-model="form.isTop" placeholder="请选择是否推荐">
            <el-option v-for="dict in dict.type.shifou" :key="dict.value" :label="dict.label"
                       :value="parseInt(dict.value)"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="最大交易数量" prop="tradeMax">
          <el-input v-model="form.tradeMax" placeholder="请输入最大交易数量"/>
        </el-form-item>
        <el-form-item label="最小交易数量" prop="tradeMin">
          <el-input v-model="form.tradeMin" placeholder="请输入最小交易数量"/>
        </el-form-item>
        <el-form-item label="币币" prop="tradeType">
          <el-select v-model="form.tradeType" placeholder="请选择币币">
            <el-option v-for="dict in dict.type.tradeType" :key="dict.value" :label="dict.label" :value="dict.value">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="交易手续费" prop="tradeRate">
          <el-input v-model="form.tradeRate" placeholder="请输入交易手续费"/>
        </el-form-item>
        <el-form-item label="主链" prop="mainFrom">
          <el-select v-model="form.mainFrom" placeholder="请选择主链">
            <el-option v-for="dict in dict.type.zp_type" :key="dict.value" :label="dict.label" :value="dict.value">
            </el-option>
          </el-select>
        </el-form-item>
        <!-- <el-form-item label="充提开关" prop="isDw">
          <el-select v-model="form.isDw" placeholder="请选择充提开关">
            <el-option
              v-for="dict in dict.type.isdw"
              :key="dict.value"
              :label="dict.label"
:value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="最提币数量" prop="withdrawMin">
          <el-input v-model="form.withdrawMin" placeholder="请输入最提币数量" />
        </el-form-item>
        <el-form-item label="提币手续费" prop="withdrawFee">
          <el-input v-model="form.withdrawFee" placeholder="请输入提币手续费" />
        </el-form-item> -->
        <el-form-item label="币类型" prop="type">
          <el-select v-model="form.pairsType" placeholder="请选择币类型">
            <el-option v-for="dict in dict.type.pair_type_su" :key="dict.value" :label="dict.label"
                       :value="parseInt(dict.value)"></el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>


    <!-- 控盘 -->
    <el-dialog title="控盘" :visible.sync="lineCode" width="1000px" append-to-body>
      <div class="f-box">
        <el-form ref="cosFrom" :rules="cosFrules" :model="cosFrom" label-width="120px">
          <el-row>
            <el-col :span="8">
              <el-form-item label="币种" prop="tokenCur">
                <el-input v-model="cosFrom.tokenCur" disabled placeholder="请输入币种"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="起始价格" prop="startingPrice">
                <el-input v-model="cosFrom.startingPrice" placeholder="请输入起始价格（浮动价格）"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="结束价格" prop="finalPrice">
                <el-input v-model="cosFrom.finalPrice" placeholder="请输入结束价格（浮动价格）"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="最大交易量" prop="tradingVolumeMax">
                <el-input v-model="cosFrom.tradingVolumeMax" placeholder="请输入最大交易量"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="最小交易量" prop="tradingVolumeMin">
                <el-input v-model="cosFrom.tradingVolumeMin" placeholder="请输入最小交易量"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="开盘价" prop="openingPrice">
                <el-input v-model="cosFrom.openingPrice" placeholder="请输入开盘价"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="收盘价" prop="closingPrice">
                <el-input v-model="cosFrom.closingPrice" placeholder="请输入收盘价"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-form-item>
            <el-button type="primary" @click="qrkp('cosFrom')">确认</el-button>
            <el-button @click="qx('cosFrom')">取 消</el-button>
          </el-form-item>
        </el-form>
      </div>

      <el-divider></el-divider>
      <div class="m-box">
        时间选择：
        <el-select v-model="scan" placeholder="请选择" @change="xz">
          <el-option
            v-for="dict in dict.type.zfb_tm_scn"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </div>
      <div class="echart" id="mychart" style="width:100%; height: 400px;"></div>
    </el-dialog>
    <!-- <div class="echart" id="mychart" style="width:100%; height: 400px;"></div> -->
  </div>
</template>

<script>
import echarts from 'echarts'
import {
  listPairs,
  getPairs,
  delPairs,
  addPairs,
  updatePairs, getKineCurs, batchSubPas
} from "@/api/system/pairs";
import {
  listCurrencyControls,
  getCurrencyControls,
  delCurrencyControls,
  addCurrencyControls,
  updateCurrencyControls
} from "@/api/line/currencyControls";

export default {
  name: "Pairs",
  dicts: ['t_pair_status', 'shifou', 't_pair_type', 'zp_type', 'isdw', 'tradeType', 'pair_type_su', 'zfb_tm_scn'],
  data() {
    return {
      cosFrom: {
        tokenCur: null,
        startingPrice: null,
        finalPrice: null,
        tradingVolumeMax: null,
        tradingVolumeMin: null,
        openingPrice: null,
        closingPrice: null,
      },
      cosFrules: {
        tokenCur: [
          {required: true, message: '请输入最高价', trigger: 'change'}
        ],
        startingPrice: [
          {required: true, message: '请输入起始价格（浮动价格）', trigger: 'change'}
        ],
        finalPrice: [
          {required: true, message: '请输入结束价格（浮动价格）', trigger: 'change'}
        ],
        tradingVolumeMax: [
          {required: true, message: '请输入最大成交量', trigger: 'change'}
        ],
        tradingVolumeMin: [
          {required: true, message: '请输入最小成交量', trigger: 'change'}
        ]
      },
      scan: "15m",
      scanCur: null,
      maxMoney: '',
      lineCode: false, // 查看k线数据
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
      // 交易对配置表格数据
      pairsList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        pairsName: null,
        mainCur: null,
        tokenCur: null,
        state: null,
        type: null,
        contract: null,
        point: null,
        image: null,
        sort: null,
        openPrice: null,
        price: null,
        chPrice: null,
        volume: null,
        open: null,
        lowPrice: null,
        higPrice: null,
        updown: null,
        isTop: null,
        tradeMax: null,
        tradeMin: null,
        tradeType: null,
        tradeRate: null,
        mainFrom: null,
        isDw: null,
        withdrawMin: null,
        withdrawFee: null,
        pairsType: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {},
      options: [
        {
          id: 1,
          val: "1分钟"
        },
        {
          id: 2,
          val: "5分钟"
        },
        {
          id: 3,
          val: "15分钟"
        },
        {
          id: 4,
          val: "30分钟"
        },
        {
          id: 5,
          val: "1小时"
        },
        {
          id: 6,
          val: "1天"
        },
        {
          id: 7,
          val: "1周"
        },
      ]
    };
  },
  created() {
    this.getList();
  },
  mounted() {
    const data = this.$route.params;
    console.log(data)
  },
  methods: {
    xz(e) {
      console.log("选择", e)
      this.scan = e;
      this.getKline();
    },
    qrkp(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          batchSubPas(this.cosFrom).then(res => {
            this.lineCode = false
            this.$refs[formName].resetFields();
          })
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    qx(formName) {
      this.lineCode = false
      this.$refs[formName].resetFields();
    },
    initEcharts(info, data) {
      const option = {
        title: {
          text: "K线"
        },
        tooltip: {},
        legend: {},
        xAxis: {
          // data: ["2017-10-24", "2017-10-25", "2017-10-26", "2017-10-27"]
          data: info
        },
        yAxis: {},
        series: [
          {
            type: "candlestick",
            data: data
            // data: [
            //   [20, 34, 10, 38], //今开、当前价格、最低价格、最高价
            //   [40, 35, 30, 50],
            //   [31, 38, 33, 44],
            //   [38, 15, 5, 42]
            // ]
          }
        ]
      };
      const myChart = echarts.init(document.getElementById("mychart"));

      myChart.setOption(option);
      //随着屏幕大小调节图表
      window.addEventListener("resize", () => {
        myChart.resize();
      });
    },
    // 控盘
    handleSee(row) {
      this.scan = "15m"
      this.scanCur = row.tokenCur;
      this.cosFrom.tokenCur = row.tokenCur;
      this.lineCode = true
      this.getKline();
      this.getControl(row.tokenCur)

      // setTimeout(() => {
      //   this.initEcharts()
      // },100)

    },
    getControl(tokenCur) {
      listCurrencyControls({tokenCur: tokenCur}).then(response => {
        this.cosFrom = response.rows[0];
        console.log('currencyControlsList====>', this.currencyControlsList)
        // this.total = response.total;
        // this.loading = false;
      });
    },
    //查询K线数据
    getKline() {
      let obj = {
        name: this.scanCur,
        time: this.scan
      }
      getKineCurs(obj).then(res => {
        this.initEcharts(res.data.info, res.data.data)
      })
    },
    /** 查询交易对配置列表 */
    getList() {
      this.loading = true;
      listPairs(this.queryParams).then(response => {
        this.pairsList = response.rows;
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
        pairsName: null,
        mainCur: null,
        tokenCur: null,
        state: null,
        type: null,
        contract: null,
        point: null,
        image: null,
        sort: null,
        openPrice: null,
        price: null,
        chPrice: null,
        volume: null,
        open: null,
        lowPrice: null,
        higPrice: null,
        updown: null,
        isTop: null,
        tradeMax: null,
        tradeMin: null,
        tradeType: null,
        tradeRate: null,
        mainFrom: null,
        updateTime: null,
        createTime: null,
        isDw: null,
        withdrawMin: null,
        withdrawFee: null
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
      this.single = selection.length !== 1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加交易对配置";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getPairs(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改交易对配置";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updatePairs(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addPairs(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除交易对配置编号为"' + ids + '"的数据项？').then(function () {
        return delPairs(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {
      });
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/pairs/export', {
        ...this.queryParams
      }, `pairs_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
<style lang="scss" scoped>
.f-box {
  display: flex;
  flex-wrap: wrap;
}

.f-input {
  display: flex;
  align-items: center;
  font-size: 16px;
  margin-right: 10px;
  margin-bottom: 10px;

  .name {
    width: 100px;
  }
}

.m-box {
  overflow: hidden;
  box-sizing: border-box;
  padding: 10px;
}
</style>
