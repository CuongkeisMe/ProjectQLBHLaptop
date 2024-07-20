package main.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import main.config.DBConnect;
import main.entity.Gpu;

public class GpuRepository {
    public ArrayList<Gpu> getAll(){
        ArrayList<Gpu> listGpu = new ArrayList<>();
        String sql = """
                     SELECT [id_GPU]
                           ,[MaGPU]
                           ,[TenGPU]
                           ,[TrangThai]
                       FROM [dbo].[GPU]
                     """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Gpu gpu = Gpu.builder()
                        .IdGPU(rs.getInt(1))
                        .MaGPU(rs.getString(2))
                        .TenGPU(rs.getString(3))
                        .TrangThai(rs.getInt(4))
                        .build();
                listGpu.add(gpu);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listGpu;
    }
}
