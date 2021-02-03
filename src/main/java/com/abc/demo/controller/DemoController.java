package com.abc.demo.controller;

import com.warrenstrange.googleauth.GoogleAuthenticator;
import com.warrenstrange.googleauth.GoogleAuthenticatorKey;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class DemoController {

    private static String secret; // 儲存的密鑰

    /**
     * 取得帶有Google Authenticator驗證器密鑰的qrcode
     *
     * @return 帶有Google Authenticator驗證氣密鑰的qrcode url
     */
    @GetMapping("/auth/qrcode")
    public RedirectView getSecretQrCode() {

        secret = genSecretKey(); // 產生並儲存密鑰

        String qrCodeData = createGoogleAuthenticatorKeyUri(secret);
        System.out.println(qrCodeData); // otpauth://totp/ABC:john@@abc.com?secret=CIIHTWBCP7AA6TXT&issuer=ABC

        String googleChartsQrCodeFormat = "https://www.google.com/chart?chs=200x200&cht=qr&chl=%s";
        String qrCodeUrl = String.format(googleChartsQrCodeFormat, qrCodeData);
        System.out.println(qrCodeUrl); // https://www.google.com/chart?chs=200x200&cht=qr&chl=otpauth://totp/ABC:john@@abc.com?secret=CIIHTWBCP7AA6TXT&issuer=ABC

        return new RedirectView(qrCodeUrl); // 重新導向到指定的url
    }

    /**
     * 產生密鑰字串
     *
     * @return 密鑰字串
     */
    private String genSecretKey() {
        GoogleAuthenticator gAuth = new GoogleAuthenticator();
        final GoogleAuthenticatorKey key = gAuth.createCredentials();
        return key.getKey();
    }

    /**
     * 建立Google Authenticator密鑰uri
     *
     * @param secret 密鑰字串
     * @return Google Authenticator密鑰uri
     */
    private String createGoogleAuthenticatorKeyUri(String secret) {
        String otpType = "totp";
        String account = "ABC:john@@abc.com";
        String issuer = "ABC";
        String googleAuthenticatorKeyUriFormat = "otpauth://%s/%s?secret=%s&issuer=%s";
        return String.format(googleAuthenticatorKeyUriFormat, otpType, account, secret, issuer);
    }

    /**
     * Google Authenticator TOTP驗證
     * @param code 一次性驗證碼
     * @return 驗證結果
     */
    @GetMapping("/auth/{code}")
    @ResponseBody
    public String googleAuthenticatorAuth(@PathVariable("code") int code) {
        GoogleAuthenticator gAuth = new GoogleAuthenticator();
        boolean isCodeValid = gAuth.authorize(secret, code); // 驗證
        return isCodeValid ? "pass" : "fail";
    }

}
