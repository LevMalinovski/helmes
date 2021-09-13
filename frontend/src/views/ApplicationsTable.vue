<template>
  <div v-loading="loading">
    <el-table
        :data="applications"
        style="width: 100%">
      <el-table-column type="expand">
        <template slot-scope="props">
          <el-tree
              :data="props.row.categories"
              node-key="id"
              ref="tree"
              :props="defaultProps">
          </el-tree>

        </template>
      </el-table-column>
      <el-table-column
          prop="name"
          label="Name"
          width="180">
      </el-table-column>
      <el-table-column
          label="Operations">
        <template slot-scope="scope">
          <el-button
              size="mini"
              @click="handleEdit(scope.$index, scope.row)">Edit</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>

</template>
<script>
import {fetchApplications} from "@/api/application";

export default {
  name: "ApplicationsTable",
  data() {
    return {
      componentKey: 0,
      loading: true,
      applications: [],
      defaultProps: {
        children: 'children',
        label: 'name'
      },
    }
  },
  created() {
    let self = this;
    fetchApplications().then(function(data) {
      self.applications = data.data;
      self.loading = false;
    });
  },
  methods: {
    handleEdit(index, row) {
    }
  }
};
</script>
