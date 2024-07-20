
package main.repository;

import java.util.ArrayList;
import main.entity.KhachHang;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import main.config.DBConnect;

public class KhachHangRepository {
    public ArrayList<KhachHang> getAll(){
        ArrayList<KhachHang> list = new ArrayList<>();
        String sql = """
                     SELECT [id_KhachHang]
                           ,[MaKhachHang]
                           ,[HoTen]
                           ,[NgaySinh]
                           ,[GioiTinh]
                           ,[SDT]
                           ,[Email]
                           ,[DiaChi]
                           ,[TrangThai]
                       FROM [dbo].[KhachHang]
                     """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                KhachHang kh = KhachHang.builder()
                        .id(rs.getInt(1))
                        .ma(rs.getString(2))
                        .ten(rs.getString(3))
                        .ngaySinh(rs.getDate(4))
                        .gioiTinh(rs.getBoolean(5))
                        .sdt(rs.getString(6))
                        .email(rs.getString(7))
                        .diaChi(rs.getString(8))
                        .trangThai(rs.getString(9))
                        .build();
                list.add(kh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
