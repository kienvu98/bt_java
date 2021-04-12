var app = angular.module('myApp', [])
app.controller('customerController', function ($scope) {
    var cus1 = new Customer("kien", "vukien", "123", "HaiPhong", 22);
    var cus2 = new Customer("Thảo", "ThaoDo", "234", "Hải Phòng", 20);
    var cus3 = new Customer("Long", "LongHoang", "345", "Hà Nội", 21);
    console.log(cus1);
    $scope.list = [cus1, cus2, cus3];

    //thêm nhân viên
    $scope.addEntry = function () {
        $scope.list.push($scope.newData);
        $scope.newData = "";
    }
    // xóa nhân viên
    $scope.removeEtry = function () {
        $scope.list.splice($scope.index, 1);

    }
    // sửa nhân viên
    $scope.edit = function (index) {
        $scope.index = index;
        $scope.lis = angular.copy($scope.list[index]);
    }

});
function Customer(uname, fname, pass, add, age) {
    this.uname = uname;
    this.fname = fname;
    this.pass = pass;
    this.add = add;
    this.age = age;
}
app.controller('editController', function ($scope) {
    $scope.save = function () {
        $scope.list[$scope.index] = angular.copy($scope.lis);
        document.querySelector("#save").setAttribute("class","hide");

    }
    $scope.cancel = function () {
        $scope.lis = angular.copy($scope.list[$scope.index]);
    }
});


