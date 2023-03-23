<template>
  <el-form ref="form" :model="user" :rules="rules" label-width="110px">
    <el-form-item label="旧操作密码" prop="oldPassword">
      <el-input v-model="user.oldPassword" placeholder="请输入旧操作密码" type="password" show-password/>
    </el-form-item>
    <el-form-item label="新操作密码" prop="newPassword">
      <el-input v-model="user.newPassword" placeholder="请输入新操作密码" type="password" show-password/>
    </el-form-item>
    <el-form-item label="确认操作密码" prop="confirmPassword">
      <el-input v-model="user.confirmPassword" placeholder="请确认新操作密码" type="password" show-password/>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" size="mini" @click="submit">保存</el-button>
      <el-button type="danger" size="mini" @click="close">关闭</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
import { updateUserOperPwd } from "@/api/system/user";

export default {
  data() {
    const equalToPassword = (rule, value, callback) => {
      if (this.user.newPassword !== value) {
        callback(new Error("两次输入的密码不一致"));
      } else {
        callback();
      }
    };
    return {
      user: {
        oldPassword: undefined,
        newPassword: undefined,
        confirmPassword: undefined
      },
      // 表单校验
      rules: {
        oldPassword: [
          { required: true, message: "旧操作密码不能为空", trigger: "blur" }
        ],
        newPassword: [
          { required: true, message: "新操作密码不能为空", trigger: "blur" },
        ],
        confirmPassword: [
          { required: true, message: "确认密码不能为空", trigger: "blur" },
          { required: true, validator: equalToPassword, trigger: "blur" }
        ]
      }
    };
  },
  methods: {
    submit() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          updateUserOperPwd(this.user.oldPassword, this.user.newPassword).then(response => {
            this.$modal.msgSuccess("修改成功");
          });
        }
      });
    },
    close() {
      this.$tab.closePage();
    }
  }
};
</script>
