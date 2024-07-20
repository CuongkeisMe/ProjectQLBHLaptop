package main.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import main.config.DBConnect;
import main.entity.ManHinh;

public class ManHinhRepository {
    public ArrayList<ManHinh> getAll(){
        ArrayList<ManHinh> listManHinh = new ArrayList<>();
        String sql = """
                     SELECT [id_ManHinh]
                           ,[MaManHinh]
                           ,[KichThuoc]
                           ,[TrangThai]
                       FROM [dbo].[ManHinh]
                     """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ManHinh mh = ManHinh.builder()
                        .IdManHinh(rs.getInt(1))
                        .MaManHinh(rs.getString(2))
                        .KichThuoc(rs.getString(3))
                        .TrangThai(rs.getInt(4))
                        .build();
                listManHinh.add(mh);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listManHinh;
    }
}
