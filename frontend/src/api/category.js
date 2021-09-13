import axios from "axios";

export function fetchList() {
    return axios.get(process.env.VUE_APP_BASE_API +'/api/v1/category')
        .then(function (response) {
           return response;
        });
}