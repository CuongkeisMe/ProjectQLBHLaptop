
package main.repository;

import java.util.ArrayList;
import main.entity.NhanVien;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import main.config.DBConnect;

public class NhanVienRepository {
    public ArrayList<NhanVien> getAll(){
        ArrayList<NhanVien> list = new ArrayList<>();
        String sql = """
                     SELECT [id_NhanVien]
                           ,[MaNhanVien]
                           ,[UserName]
                           ,[Pass]
                           ,[HoTen]
                           ,[NgaySinh]
                           ,[GioiTinh]
                           ,[SDT]
                           ,[Email]
                           ,[DiaChi]
                           ,[VaiTro]
                           ,[TrangThai]
                       FROM [dbo].[NhanVien]
                     """;
        try(Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                NhanVien nv = NhanVien.builder()
                        .id(rs.getInt(1))
                        .ma(rs.getString(2))
                        .userName(rs.getString(3))
                        .pass(rs.getString(4))
                        .ten(rs.getString(5))
                        .ngaySinh(rs.getDate(6))
                        .gioiTinh(rs.getBoolean(7))
                        .sdt(rs.getString(8))
                        .email(rs.getString(9))
                        .diaChi(rs.getString(10))
                        .vaiTro(rs.getString(11))
                        .trangThai(rs.getString(12))
                        .build();
                list.add(nv);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public Boolean add(NhanVien nv){
        String sql = """
                     INSERT INTO [dbo].[NhanVien]
                                (
                                [UserName]
                                ,[Pass]
                                ,[HoTen]
                                ,[NgaySinh]
                                ,[GioiTinh]
                                ,[SDT]
                                ,[Email]
                                ,[DiaChi]
                                ,[VaiTro]
                                ,[TrangThai])
                          VALUES (?,?,?,?,?,?,?,?,?,1)
                     """;
        int check = 0; 
        try(Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, nv.getUserName());
            ps.setObject(2, nv.getPass());
            ps.setObject(3, nv.getTen());
            ps.setObject(4, nv.getNgaySinh());
            ps.setObject(5, nv.isGioiTinh());
            ps.setObject(6, nv.getSdt());
            ps.setObject(7, nv.getEmail());
            ps.setObject(8, nv.getDiaChi());
            ps.setObject(9, nv.getVaiTro());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check >0 ;
    }
}
