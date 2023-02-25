create database furama_management;
use furama_management;
create table vi_tri(
ma_vi_tri int,
ten_vi_tri varchar(99),
primary key(ma_vi_tri)
);
create table trinh_do(
ma_trinh_do int,
ten_trinh_do varchar(99),
primary key(ma_trinh_do)
);
create table bo_phan(
ma_bo_phan int,
ten_bo_phan varchar(99),
primary key(ma_bo_phan)
);
create table dich_vu_di_kem(
ma_dich_vu_di_kem int,
ten_dich_vu_di_kem varchar(99),
gia double,
don_vi varchar(10),
trang_thai varchar(45),
primary key(ma_dich_vu_di_kem)
);
create table loai_khach(
ma_loai_khach int,
ten_loai_khach varchar(45),
primary key(ma_loai_khach)
);
create table khach_hang(
ma_khach_hang int,
ma_loai_khach int,
ho_ten varchar(99),
ngay_sinh date,
gioi_tinh bit(1),
so_cmnd varchar(99),
so_dien_thoai varchar(99),
email varchar(99),
dia_chi varchar(99),
primary key (ma_khach_hang),
foreign key (ma_loai_khach) references loai_khach(ma_loai_khach)
);
create table loai_dich_vu(
ma_loai_dich_vu int,
ten_loai_dich_vu varchar(99),
primary key(ma_loai_dich_vu)
);
create table kieu_thue(
ma_kieu_thue int,
ten_kieu_thue varchar(99),
primary key(ma_kieu_thue)
);
create table dich_vu(
ma_dich_vu int,
ten_dich_vu varchar(99),
dien_tich int,
chi_phi_thue double,
so_nguoi_toi_da int,
ma_kieu_thue int,
ma_loai_dich_vu int,
tieu_chuan_phong varchar(99),
mo_ta_tien_nghi_khac varchar(99),
dien_tich_ho_boi double,
so_tang int,
primary key (ma_dich_vu),
foreign key (ma_kieu_thue) references kieu_thue(ma_kieu_thue),
foreign key (ma_loai_dich_vu) references loai_dich_vu(ma_loai_dich_vu)
);
create table nhan_vien(
ma_nhan_vien int,
ho_ten varchar(99),
ngay_sinh date,
so_cmnd varchar(99),
luong double,
so_dien_thoai varchar(99),
email varchar(99),
dia_chi varchar(45),
ma_vi_tri int,
ma_trinh_do int,
ma_bo_phan int,
primary key (ma_nhan_vien),
foreign key (ma_vi_tri) references vi_tri(ma_vi_tri),
foreign key (ma_trinh_do) references trinh_do(ma_trinh_do),
foreign key (ma_bo_phan) references bo_phan(ma_bo_phan)
);
create table hop_dong(
ma_hop_dong int,
ngay_lam_hop_dong date,
ngay_ket_thuc date,
tien_dat_coc double,
ma_nhan_vien int,
ma_khach_hang int,
ma_dich_vu int,
primary key (ma_hop_dong),
foreign key (ma_nhan_vien) references nhan_vien(ma_nhan_vien),
foreign key (ma_khach_hang) references khach_hang(ma_khach_hang),
foreign key (ma_dich_vu) references dich_vu(ma_dich_vu)
);
create table hop_dong_chi_tiet (
ma_hop_dong_chi_tiet int,
ma_hop_dong int,
ma_dich_vu_di_kem int,
so_luong int,
primary key (ma_hop_dong_chi_tiet),
foreign key (ma_hop_dong) references hop_dong(ma_hop_dong),
foreign key (ma_dich_vu_di_kem) references dich_vu_di_kem(ma_dich_vu_di_kem)
);