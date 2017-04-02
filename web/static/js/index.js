/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function showNotify(message, type) {
    $.notify(message, type, {
        position: "top right",
        autoHide: true,
        clickToHide: true,
        autoHideDelay: 5000
    });
}


$(document).ready(function () {
    var isUpdate = false;
    $('#tbNhanVien').DataTable({
        processing: true,
        serverSide: false,
        ajax: "ProcessData",
        rowId: "id",
        columns: [
            {data: "maNhanVien", defaultContent: ''},
            {
                data: null,
                render: function (data) {
                    return data.ho + " " + data.ten;
                },
                defaultContent: ''
            },
            {
                data: "gioiTinh",
                defaultContent: ''
            },
            {
                data: "ngaySinh",
                defaultContent: ''
            },
            {
                data: "noiSinh",
                defaultContent: ''
            },
            {
                data: null,
                render: function (data) {
                    if (data.hinhAnh !== undefined && data.hinhAnh !== '') {
                        return '<img src="static/images/' + data.hinhAnh + '" class="img-thumbnail" /> ';
                    }
                },
                defaultContent: 'Chưa có hình'
            },
            {
                data: null,
                render: function (data) {
                    return '<a href="javascript: void(0);" class="btn btn-warning update" >Edit</a> <a href="#" data-id="' + data.id + '" class="btn btn-danger delete" >Delete</a>';
                }
            }
        ]
    });
    $('#btnThemNhanVien').click(function () {
        isUpdate = false;
        $("#crudModal").modal('show');
    });

    $(document).on('click', '.update', function () {
        isUpdate = true;
        var dtb = $("#tbNhanVien").DataTable();
        var data = dtb.row($(this).parents('tr')).data();
        $("#crudModal input[name='hinhAnh']").attr('data-bind', '');
        bindData(data);
        $("#crudModal").modal('show');
    });

    $(document).on('click', '.delete', function () {
        $.post({

        });
    });

    var bangCapModel = function () {
        var self = this;
        self.data = {
            id: ko.observable(0),
            tenBangCap: ko.observable(''),
            ngayCap: ko.observable(''),
            noiCap: ko.observable('')
        };
        self.listBangCap = ko.observableArray();
        self.addBangCap = function () {
            self.listBangCap.push(ko.toJS(self.data));
            self.clearData();
        };
        self.removeBangCap = function (bangCap) {
            self.listBangCap.remove(bangCap);
        };
        self.clearData = function () {
            self.data.id();
            self.data.tenBangCap('');
            self.data.ngayCap('');
            self.data.noiCap('');
        }

    }

    var viewModel = function () {
        var self = this;
        self.data = {
            id: ko.observable(0),
            maNhanVien: ko.observable(''),
            ho: ko.observable(''),
            ten: ko.observable(''),
            gioiTinh: ko.observable(1),
            matKhau: ko.observable(''),
            ngaySinh: ko.observable(''),
            noiSinh: ko.observable(''),
            diaChiThuongTru: ko.observable(''),
            diaChiTamTru: ko.observable(''),
            hinhAnh: ko.observable(''),
            userdiplomas: ko.observableArray()
        };

        self.save = function () {
            self.data.userdiplomas = bangCapModel.listBangCap;
            console.log(ko.toJSON(self.data));
            var data = ko.toJSON(self.data);
            var url = isUpdate ? "ProcessUpdate" : "ProcessCreate";
            $.post({
                url: url,
                data: {
                    data: data
                },
                dataType: 'json',
                success: function (data) {
                    showNotify(isUpdate ? "Cập nhật thành công" : "Thêm thành công");
                    $('#crudModal').modal('hide');
                },
                error: function () {
                    console.log(data);
                }
            })
        };


        self.update = function () {

        }

    };
    var model = new viewModel();
    var bangCapModel = new bangCapModel();
    ko.applyBindings(model, $('.nhanVien')[0]);
    ko.applyBindings(model, $('.modal-footer')[0])
    ko.applyBindings(bangCapModel, $('.bangCap')[0]);

    function bindData(data) {
        model.data = {
            id: ko.observable(data.id),
            maNhanVien: ko.observable(data.maNhanVien),
            ho: ko.observable(data.ho),
            ten: ko.observable(data.ten),
            gioiTinh: ko.observable(data.gioiTinh),
            matKhau: ko.observable(data.matKhau),
            ngaySinh: ko.observable(data.ngaySinh),
            noiSinh: ko.observable(data.noiSinh),
            diaChiThuongTru: ko.observable(data.diaChiThuongTru),
            diaChiTamTru: ko.observable(data.diaChiTamTru),
            hinhAnh: ko.observable(data.hinhAnh),
            userdiplomas: ko.observableArray('')
        }
        $.post({
            url: "ProcessDiploma",
            data: {
                "userId": model.data.id
            },
            dataType: "json",
            success: function (data) {
                model.data.userdiplomas(data.result);
                bangCapModel.listBangCap(data.result);

                console.log(model.data.userdiplomas());
            }
        });
        console.log(model.data);
        ko.cleanNode($('.nhanVien')[0]);
        ko.applyBindings(model, $('.nhanVien')[0]);
        console.log(data);
    }

    $(document).on('shown.bs.modal', $("#crudModal"), function () {
        $('input[type="file"]').on('change', function () {
            var formData = new FormData();
            formData.append('images', $(this)[0].files[0]);
            $.post({
                url: "ProcessFileUpload",
                data: formData,
                contentType: false,
                processData: false
            }).then(function (data) {
                $("#imgView").attr("src", "static/images/" + model.data.hinhAnh() + "?timestamp=" + new Date().getTime());
            });
        });
    });

});
