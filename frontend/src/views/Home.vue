<template>
  <div v-loading="loading">
    <el-row :gutter="20">
      <el-col :span="12">
        <el-card class="box-card">
          <div slot="header" class="clearfix">
            <span>Please enter your name and pick the Sectors you are currently involved in.</span>
          </div>
          <div>
            <el-form ref="applicationForm" :model="applicationForm" :rules="rules" label-width="120px">
              <el-form-item label="Name" prop="name">
                <el-input v-model="applicationForm.name"></el-input>
              </el-form-item>
              <el-form-item label="Sectors" prop="categories">
                <el-tree
                    v-model="applicationForm.categories"
                    :data="categories"
                    show-checkbox
                    node-key="id"
                    ref="tree"
                    :props="defaultProps">
                </el-tree>
              </el-form-item>
              <el-form-item label="Agree to terms" prop="terms">
                <el-switch v-model="applicationForm.terms"></el-switch>
              </el-form-item>
              <el-form-item>
                <el-button type="primary" @click="createApplication('applicationForm')">Save</el-button>
              </el-form-item>
            </el-form>
          </div>
        </el-card>
      </el-col>
      <el-col :span="12">
        <ApplicationsTable :key="componentKey"/>
      </el-col>
    </el-row>
  </div>

</template>
<script>
import {fetchList} from "@/api/category";
import {create} from "@/api/application";
import ApplicationsTable from "@/views/ApplicationsTable";

export default {
  name: "Home",
  components: {ApplicationsTable},
  data() {
    let requiredTerms = (rule, value, callback) => {
      if (!value) {
        return callback(new Error('Please input the age'));
      }
      callback();
    };
    return {
      componentKey: 1,
      loading: true,
      defaultProps: {
        children: 'children',
        label: 'name'
      },
      applicationForm: {
        name: null,
        categories: [],
        terms: false
      },
      categories: [],
      rules: {
        name: [
          {required: true, message: 'Please input name', trigger: 'blur'},
          {min: 3, max: 255, message: 'Length should be 3 to 255', trigger: 'blur'}
        ],
        terms: [
          {validator: requiredTerms, required: true, message: 'Please confirm terms', trigger: 'blur'},
        ],
        categories: [
          {type: 'array', message: 'Please select at least one sector', trigger: 'change'}
        ],
      }
    }
  },
  created() {
    let self = this;
    fetchList().then(function (r) {
      self.categories = r.data;
      self.loading = false;
    });
  },
  methods: {
    createApplication(formName) {
      let sectors = this.$refs.tree.getCheckedNodes();
      this.applicationForm.categories = [];
      sectors.forEach(row => {
        this.applicationForm.categories.push(row.id);
      });
      this.$refs[formName].validate((valid) => {
        if (valid) {
          create(this.applicationForm).then(r => this.componentKey++)
        } else {
          return false;
        }
      });
    }
  }
};
</script>