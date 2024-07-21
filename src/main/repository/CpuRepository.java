package main.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import main.config.DBConnect;
import main.entity.CPU;


public class CPURepository {
    public ArrayList<CPU> getAll(){
        ArrayList<CPU> listCPU = new ArrayList<>();
        String sql = """
                     SELECT [id_CPU]
                           ,[MaCPU]
                           ,[TenCPU]
                           ,[TrangThai]
                       FROM [dbo].[CPU]
                     """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                CPU cpu = CPU.builder()
                        .IdCPU(rs.getInt(1))
                        .MaCPU(rs.getString(2))
                        .TenCPU(rs.getString(3))
                        .TrangThai(rs.getInt(4))
                        .build();
                listCPU.add(cpu);
            }     
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listCPU;
    }
}
