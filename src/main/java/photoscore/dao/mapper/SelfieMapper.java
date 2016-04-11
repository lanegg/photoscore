package photoscore.dao.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import photoscore.model.selfie.Selfie;

/**
 * Created by lanegg on 16/4/10.
 */
@Repository(value = "selfieMapper")
public interface SelfieMapper {


    /**
     * 保存selfie
     * @param selfie
     * @return
     */
    @Insert("insert into selfie(id, photoPath, photoDescribe, status, creator, isDelete, createTime, updateTime) " +
            "values(null, #{selfie.photoPath}, #{selfie.photoDescribe}, #{selfie.status}, #{selfie.creator}, " +
            "#{selfie.isDelete}, #{selfie.createTime}, #{selfie.updateTime})")
    public int saveSelfie(@Param("selfie") Selfie selfie);

    /**
     * 查询用户最后一次上传的图片
     * @param creator
     * @return
     */
    @Select("select * from selfie where status = 'upload' and isDelete = 0 and creator = #{creator} order by createTime desc limit 1")
    public Selfie loadLastUpload(@Param("creator") int creator);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Select("select * from selfie where id = #{id}")
    public Selfie loadById(@Param("id") final long id);

    @Update("update selfie set photoDescribe = #{photoDescribe}, status = #{status}, updateTime = #{updateTime} where id = #{id}")
    public int publish(@Param("id") final long id, @Param("photoDescribe") final String photoDescribe, @Param("status") final String status, @Param("updateTime") final String updateTime);



}
