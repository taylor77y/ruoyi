<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="88px">
      <!-- <el-form-item label="会员ID" prop="memberId">
        <el-input
          v-model="queryParams.memberId"
          placeholder="请输入会员ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
      <el-form-item label="会员UUID" prop="uuid">
        <el-input
          v-model="queryParams.uuid"
          placeholder="请输入会员UUID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="秒配置ID" prop="sid">
        <el-input
          v-model="queryParams.sid"
          placeholder="请输入秒配置ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="虚拟币ID" prop="ckid">
        <el-input
          v-model="queryParams.ckid"
          placeholder="请输入虚拟币ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="虚拟币名称" prop="ckName">
        <el-input
          v-model="queryParams.ckName"
          placeholder="请输入虚拟币名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="开始价格" prop="startAmount">
        <el-input
          v-model="queryParams.startAmount"
          placeholder="请输入开始价格"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="结束价格" prop="finishsAmount">
        <el-input
          v-model="queryParams.finishsAmount"
          placeholder="请输入结束价格"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="下注金额" prop="amount">
        <el-input
          v-model="queryParams.amount"
          placeholder="请输入下注金额"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="利润" prop="profit">
        <el-input
          v-model="queryParams.profit"
          placeholder="请输入利润"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="买入状态" prop="buyStatus">
        <el-select v-model="queryParams.buyStatus" placeholder="请选择买入状态 1涨2跌" clearable>
          <el-option
            v-for="dict in dict.type.seconds_bet_buy_status"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="结算状态" prop="settleStatus">
        <el-select v-model="queryParams.settleStatus" placeholder="请选择结算状态" clearable>
          <el-option
            v-for="dict in dict.type.seconds_bet_settle_status"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="是否输赢" prop="isWin">
        <el-select v-model="queryParams.isWin" placeholder="请选择是否输赢" clearable>
          <el-option
            v-for="dict in dict.type.seconds_bet_win_status"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
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
      <el-form-item label="控盘配置" prop="controlPecent">
        <el-input
          v-model="queryParams.controlPecent"
          placeholder="请输入控盘配置"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="结算时间" prop="settleTime">
        <el-date-picker clearable
          v-model="queryParams.settleTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择结算时间">
        </el-date-picker>
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
          v-hasPermi="['system:secondsBetLog:add']"
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
          v-hasPermi="['system:secondsBetLog:edit']"
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
          v-hasPermi="['system:secondsBetLog:remove']"
        >删除</el-button>
      </el-col> -->
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:secondsBetLog:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="secondsBetLogList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="ID" align="center" prop="id" />
      <el-table-column label="会员手机" align="center" prop="phone"  />
      <el-table-column label="会员邮箱" align="center" prop="mail"  />
      <el-table-column label="秒配置ID" align="center" prop="sid" />
      <el-table-column label="虚拟币ID" align="center" prop="ckid" />
      <el-table-column label="虚拟币币种" align="center" prop="ckType" />
      <el-table-column label="虚拟币名称" align="center" prop="ckName" />
      <el-table-column label="开始价格" align="center" prop="startAmount" />
      <el-table-column label="结束价格" align="center" prop="finishsAmount" />
      <el-table-column label="下注金额" align="center" prop="amount" />
      <el-table-column label="利润" align="center" prop="profit" />
      <el-table-column label="买入状态" align="center" prop="buyStatus">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.seconds_bet_buy_status" :value="scope.row.buyStatus"/>
        </template>
      </el-table-column>
      <el-table-column label="结算状态" align="center" prop="settleStatus">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.seconds_bet_settle_status" :value="scope.row.settleStatus"/>
        </template>
      </el-table-column>
      <el-table-column label="是否输赢" align="center" prop="isWin">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.seconds_bet_win_status" :value="scope.row.isWin"/>
        </template>
      </el-table-column>
      <el-table-column label="是否控盘" align="center" prop="isControl">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.seconds_bet_control_status" :value="scope.row.isControl"/>
        </template>
      </el-table-column>
      <el-table-column label="控盘配置" align="center" prop="controlPecent" />
      <el-table-column label="结算时间" align="center" prop="settleTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.settleTime) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="创建时间" align="center" prop="createTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createTime) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" fixed="right" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            
          >控盘</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:secondsBetLog:remove']"
          >删除</el-button>
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

    <!-- 添加或修改秒合约记录对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <!-- <el-form-item label="会员ID" prop="memberId">
          <el-input v-model="form.memberId" placeholder="请输入会员ID" />
        </el-form-item>
        <el-form-item label="秒配置ID" prop="sid">
          <el-input v-model="form.sid" placeholder="请输入秒配置ID" />
        </el-form-item>
        <el-form-item label="虚拟币ID" prop="ckid">
          <el-input v-model="form.ckid" placeholder="请输入虚拟币ID" />
        </el-form-item>
        <el-form-item label="虚拟币名称" prop="ckName">
          <el-input v-model="form.ckName" placeholder="请输入虚拟币名称" />
        </el-form-item>
        <el-form-item label="开始价格" prop="startAmount">
          <el-input v-model="form.startAmount" placeholder="请输入开始价格" />
        </el-form-item>
        <el-form-item label="结束价格" prop="finishsAmount">
          <el-input v-model="form.finishsAmount" placeholder="请输入结束价格" />
        </el-form-item>
        <el-form-item label="下注金额" prop="amount">
          <el-input v-model="form.amount" placeholder="请输入下注金额" />
        </el-form-item>
        <el-form-item label="利润" prop="profit">
          <el-input v-model="form.profit" placeholder="请输入利润" />
        </el-form-item>
        <el-form-item label="买入状态 1涨2跌" prop="buyStatus">
          <el-select v-model="form.buyStatus" placeholder="请选择买入状态 1涨2跌">
            <el-option
              v-for="dict in dict.type.seconds_bet_buy_status"
              :key="dict.value"
              :label="dict.label"
:value="parseInt(dict.value)"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="结算状态" prop="settleStatus">
          <el-select v-model="form.settleStatus" placeholder="请选择结算状态">
            <el-option
              v-for="dict in dict.type.seconds_bet_settle_status"
              :key="dict.value"
              :label="dict.label"
:value="parseInt(dict.value)"
            ></el-option>
          </el-select>
        </el-form-item> -->
        <!-- <el-form-item label="是否输赢" prop="isWin">
          <el-select v-model="form.isWin" placeholder="请选择是否输赢">
            <el-option
              v-for="dict in dict.type.seconds_bet_win_status"
              :key="dict.value"
              :label="dict.label"
:value="parseInt(dict.value)"
            ></el-option>
          </el-select>
        </el-form-item> -->
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
        <el-form-item label="控盘配置" prop="controlPecent">
          <el-input v-model="form.controlPecent" placeholder="请输入控盘配置" />
        </el-form-item>
        <!-- <el-form-item label="结算时间" prop="settleTime">
          <el-date-picker clearable
            v-model="form.settleTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择结算时间">
          </el-date-picker>
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
import { listSecondsBetLog, getSecondsBetLog, delSecondsBetLog, addSecondsBetLog, updateSecondsBetLog } from "@/api/system/secondsBetLog";

export default {
  name: "SecondsBetLog",
  dicts: ['seconds_bet_settle_status', 'seconds_bet_win_status', 'seconds_bet_control_status', 'seconds_bet_buy_status'],
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
      // 秒合约记录表格数据
      secondsBetLogList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        memberId: null,
        sid: null,
        ckid: null,
        ckType: null,
        ckName: null,
        startAmount: null,
        finishsAmount: null,
        amount: null,
        profit: null,
        buyStatus: null,
        settleStatus: null,
        isWin: null,
        isControl: null,
        controlPecent: null,
        settleTime: null,
        uuid:null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        memberId: [
          { required: true, message: "会员ID不能为空", trigger: "blur" }
        ],
        sid: [
          { required: true, message: "秒配置ID不能为空", trigger: "blur" }
        ],
        ckName: [
          { required: true, message: "虚拟币名称不能为空", trigger: "blur" }
        ],
        startAmount: [
          { required: true, message: "开始价格不能为空", trigger: "blur" }
        ],
        amount: [
          { required: true, message: "下注金额不能为空", trigger: "blur" }
        ],
        profit: [
          { required: true, message: "利润不能为空", trigger: "blur" }
        ],
        buyStatus: [
          { required: true, message: "买入状态 1涨2跌不能为空", trigger: "change" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询秒合约记录列表 */
    getList() {
      this.loading = true;
      listSecondsBetLog(this.queryParams).then(response => {
        this.secondsBetLogList = response.rows;
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
        sid: null,
        ckid: null,
        ckType: null,
        ckName: null,
        startAmount: null,
        finishsAmount: null,
        amount: null,
        profit: null,
        buyStatus: null,
        settleStatus: null,
        isWin: null,
        isControl: null,
        controlPecent: null,
        createTime: null,
        settleTime: null
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
      this.title = "添加秒合约记录";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getSecondsBetLog(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改秒合约记录";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateSecondsBetLog(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addSecondsBetLog(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除秒合约记录编号为"' + ids + '"的数据项？').then(function() {
        return delSecondsBetLog(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/secondsBetLog/export', {
        ...this.queryParams
      }, `secondsBetLog_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
