package com.detrasoft.historapp.auth.infrastructure.token;


import com.detrasoft.historapp.auth.domain.entities.User;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CustomTokenEnhancer implements TokenEnhancer {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        User userSystem = (User) authentication.getPrincipal();

        Map<String, Object> addInfo = new HashMap<>();
        addInfo.put("first_name", userSystem.getFirstName());
        addInfo.put("last_name", userSystem.getLastName());
        addInfo.put("id_user", userSystem.getId());
        addInfo.put("id_detrasoft", userSystem.getIdDetrasoft());
        addInfo.put("url_home", userSystem.getUrlHome());
        addInfo.put("business", userSystem.getBusiness());
        addInfo.put("img", userSystem.getUrlImage());

        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(addInfo);
        return accessToken;
    }

}
