<!DOCTYPE html>
<html lang="ko" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>자판기 프로그램</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
    <div class="bg-red-700 pt-3 text-center font-semibold">
        <div>
            <h2 class="text-2xl font-bold text-white" th:text="#{update.title}">자판기 상품 수정</h2>
        </div>
        <form method="get">
            <div class="mx-3">
                <label for="pdName" class="text-white text-left" th:text="#{pdName}">상품명: </label><br>
                <input type="text" id="pdName" name="pdName" th:value="|${pdName}|" >
            </div>
            <div class="mx-3">
                <label for="pdPrice" class="text-white text-left" th:text="#{pdPrice}">가격: </label><br>
                <input type="text" id="pdPrice" name="pdPrice" th:value="|${pdPrice}|">
            </div>
            <div class="mx-3 mb-3">
                <label for="pdDate" class="text-white text-left" th:text="#{pdLimitdate}">유통기한: </label><br>
                <input type="date" id="pdDate" name="pdLimitDate" th:value="|${pdLimitDate}|">
            </div>
            <input type="hidden" name="index" th:value="${ index }">
            <input type="submit" th:value="#{update.updateBtn}" formaction="update-action" onclick="productEdited()" class="rounded-lg bg-black text-white px-3 py-2 m-1" />
            <button type="button" onclick="history.back();" class="rounded-lg bg-white px-3 py-2" th:text="#{backBtn}">돌아가기</button>
        </form>
    </div>

    <script>
        function productEdited() {
        alert("상품을 수정하였습니다!");
      }

      $(document).ready(function () {
        $(".datepicker").datepicker({
          format: "yyyy-mm-dd", // 날짜 형식 설정
          language: "kr", // 언어 설정 (한국어)
          autoclose: true, // 선택 후 자동으로 닫힘
        });
      });
    </script>
</body>
</html>