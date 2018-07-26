package lk.ijse.eCommerce.dto;

public class UserDTO {

    private String userName;
    private String password;
    private String imgUrl;

    public UserDTO() {
    }

    public UserDTO(String userName, String password, String imgUrl) {
        this.userName = userName;
        this.password = password;
        this.imgUrl = imgUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
