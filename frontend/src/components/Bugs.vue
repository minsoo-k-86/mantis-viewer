<script setup lang="ts">
import { ref } from "vue";
import { MultiSelect, InputGroup, InputGroupAddon, InputText, Button, Toast } from "primevue";
import { useToast } from "primevue/usetoast";
import { Bug, User } from "@/interfaces";
import { AgGridVue } from "ag-grid-vue3";
import { AllCommunityModule, ModuleRegistry } from 'ag-grid-community';
import dayjs from "dayjs";
import Cookies from 'js-cookie';
import axios from 'axios';

// Register all community features
ModuleRegistry.registerModules([AllCommunityModule]);

const toast = useToast();

let selectedUsers = ref([]);
let newUserId = ref('');
const bugs: Bug[] = getTestData();
const columnDefs = ref([
  { field: "rowNumber", headerName: "순서", width: 100 },
  { field: "projectName", headerName: "제품명" },
  { field: "categoryName", headerName: "분류" },
  { field: "summary", headerName: "제목", width: 400 },
  { field: "status", headerName: "상태" },
  { field: "reporterId", headerName: "보고자 ID" },
  { field: "reporterName", headerName: "보고자 이름" },
  { field: "handlerId", headerName: "담당자 ID" },
  { field: "handlerName", headerName: "담당자 이름" },
  { field: "dataSubmitted", headerName: "등록일", width: 120, valueFormatter: p => dayjs(p.value).format('YYYY-MM-DD') },
]);

const showUsers = ref(getUsers());

/**
 * 테스트 데이터 조회
 */
function getTestData() {
  return [
    {
      "rowNumber": 1,
      "projectName": "Romero-Baker",
      "categoryName": "architect efficient web-readiness",
      "summary": "Manage should under expert lawyer suddenly challenge.",
      "status": "Pending",
      "reporterId": "ff68abbc-c7fd-45cf-8dd9-31deff73db6c",
      "reporterName": "Matthew Arellano",
      "handlerId": "ad7c9549-2499-4e11-9079-9b7b17133e66",
      "handlerName": "Joan Rose",
      "dataSubmitted": "2025-01-07T02:08:49"
    },
    {
      "rowNumber": 2,
      "projectName": "Rodriguez-Maldonado",
      "categoryName": "exploit visionary e-services",
      "summary": "Room single evidence week candidate however.",
      "status": "In Progress",
      "reporterId": "baa9a343-36f1-42a1-b063-db3ccd0905eb",
      "reporterName": "Dr. Brandi Bowman",
      "handlerId": "051fe525-f111-4f25-ab91-bf6c1e857145",
      "handlerName": "Dr. Michael Scott",
      "dataSubmitted": "2025-01-13T07:21:25"
    },
    {
      "rowNumber": 3,
      "projectName": "Allison-King",
      "categoryName": "revolutionize e-business infrastructures",
      "summary": "Natural bring campaign sense education politics.",
      "status": "Pending",
      "reporterId": "ed9cf0b2-b0fb-4cba-83f0-8d350f03c4dc",
      "reporterName": "Stephanie Gonzalez MD",
      "handlerId": "909eaee5-80e9-4618-8007-b893c5069c2e",
      "handlerName": "Samantha Lewis",
      "dataSubmitted": "2025-01-09T14:59:11"
    },
    {
      "rowNumber": 4,
      "projectName": "Long PLC",
      "categoryName": "engineer dynamic supply-chains",
      "summary": "Station wide institution.",
      "status": "In Progress",
      "reporterId": "01b2e294-0a5a-4776-88ac-a6ef645e92e2",
      "reporterName": "Annette Taylor",
      "handlerId": "83034e4a-e3ab-4fc7-98b1-3f0f56f920be",
      "handlerName": "Brandon Wu",
      "dataSubmitted": "2025-01-02T06:48:57"
    },
    {
      "rowNumber": 5,
      "projectName": "Patterson-Smith",
      "categoryName": "morph vertical schemas",
      "summary": "Parent how by program.",
      "status": "Pending",
      "reporterId": "8515eaef-c904-4ceb-a914-5f0072755adb",
      "reporterName": "Miss Lori Martin MD",
      "handlerId": "611c539d-7827-47f9-b64d-244c17cedfea",
      "handlerName": "Jennifer Porter",
      "dataSubmitted": "2025-01-13T19:09:20"
    },
    {
      "rowNumber": 6,
      "projectName": "Pittman Inc",
      "categoryName": "benchmark killer relationships",
      "summary": "Indeed cut both scene participant market.",
      "status": "In Progress",
      "reporterId": "b87a5880-db5b-4ca2-b86e-4cafa48e72eb",
      "reporterName": "Matthew Meyers",
      "handlerId": "790ad5a1-71d4-4e76-a9af-eda777df828e",
      "handlerName": "Bethany Baird",
      "dataSubmitted": "2025-01-07T01:30:12"
    }
  ]
}

/**
 * 사용자 추가
 */
function addUser() {
  console.log('addUser = %s', newUserId.value);

  // TODO 사용자 확인
  const existUser = checkUser(newUserId.value);
  if(!existUser){
    // 토스트 표시
    toast.add({severity: "error", summary: "실패", detail: "존재하지 않는 사용자입니다.", life: 3000});
    return;
  }

  // 쿠키 저장
  let userStr = Cookies.get('users');
  let userArr = userStr ? userStr.split('|') : [];
  userArr.push(existUser.id);
  Cookies.set('users', userArr.join('|'));

  // 토스트 표시
  toast.add({severity: "success", summary: "완료", detail: "사용자가 추가되었습니다.", life: 3000});

  // 입력 초기화
  newUserId.value = '';
}

/**
 * 사용자 확인
 * @param userId 사용자 ID
 */
function checkUser(userId) {
  console.log('checkUser, userId = %s', userId);
  const tempUser: User = {
    id: 'mskim219',
    name: '김민수'
  };
  return tempUser;
  // axios.get('');
}

/**
 * 사용자 조회
 */
function getUsers() {
  const user1: User = {
    id: 'mskim219',
    name: '김민수'
  };
  const user2: User = {
    id: 'gglee',
    name: '이광규'
  };
  return [user1, user2];
}
</script>

<template>

  <Toast />

  <div class="grid">

    <!-- 대상 사용자 설정 -->
    <div class="col-12">
      <h3 class="mb-0">사용자 지정</h3>
    </div>

    <!-- 사용자 선택 -->
    <div class="col-4">
      <MultiSelect
          v-model="selectedUsers"
          name="showUser"
          option-label="name"
          placeholder="사용자 지정"
          style="width: 100%;"
          :options="showUsers"
      ></MultiSelect>
    </div>

    <!-- 사용자 추가 -->
    <form class="col-8" @submit.prevent="addUser">
      <InputGroup>
        <InputText v-model="newUserId" placeholder="사용자 ID" />
        <InputGroupAddon>
          <Button><i class="pi pi-user-plus"></i></Button>
        </InputGroupAddon>
      </InputGroup>
    </form>

    <div class="col-12">
      <!-- 버그 목록 -->
      <h3>버그 목록</h3>
      <ag-grid-vue
          rowModelType="clientSide"
          style="height: 500px;"
          :rowData="bugs"
          :columnDefs="columnDefs"
      ></ag-grid-vue>
    </div>

  </div>
</template>

<style scoped>

</style>