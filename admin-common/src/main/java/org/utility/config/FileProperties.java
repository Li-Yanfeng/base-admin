package org.utility.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.utility.constant.AdminConsts;

/**
 * 文件属性配置
 *
 * @author Li Yanfeng
 */
@Configuration
@ConfigurationProperties(prefix = "file")
public class FileProperties {

    /**
     * 文件大小限制
     */
    private Long maxSize;
    /**
     * 头像大小限制
     */
    private Long avatarMaxSize;

    private AdminPath mac;

    private AdminPath linux;

    private AdminPath windows;

    public AdminPath getPath() {
        String os = System.getProperty("os.name");
        if (os.toLowerCase().startsWith(AdminConsts.WIN)) {
            return windows;
        } else if (os.toLowerCase().startsWith(AdminConsts.MAC)) {
            return mac;
        }
        return linux;
    }

    public static class AdminPath {

        private String path;

        private String avatar;


        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        @Override
        public String toString() {
            return "AdminPath{" +
                    "path='" + path + '\'' +
                    ", avatar='" + avatar + '\'' +
                    '}';
        }
    }


    public Long getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(Long maxSize) {
        this.maxSize = maxSize;
    }

    public Long getAvatarMaxSize() {
        return avatarMaxSize;
    }

    public void setAvatarMaxSize(Long avatarMaxSize) {
        this.avatarMaxSize = avatarMaxSize;
    }

    public AdminPath getMac() {
        return mac;
    }

    public void setMac(AdminPath mac) {
        this.mac = mac;
    }

    public AdminPath getLinux() {
        return linux;
    }

    public void setLinux(AdminPath linux) {
        this.linux = linux;
    }

    public AdminPath getWindows() {
        return windows;
    }

    public void setWindows(AdminPath windows) {
        this.windows = windows;
    }

    @Override
    public String toString() {
        return "FileProperties{" +
                "maxSize=" + maxSize +
                ", avatarMaxSize=" + avatarMaxSize +
                ", mac=" + mac +
                ", linux=" + linux +
                ", windows=" + windows +
                '}';
    }
}

