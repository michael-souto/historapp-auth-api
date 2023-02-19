package com.detrasoft.historapp.auth.api.controllers.users.profile;

import com.detrasoft.historapp.auth.api.converters.UserProfileConverter;
import com.detrasoft.historapp.auth.api.dto.user.UserProfileDTO;
import com.detrasoft.historapp.auth.domain.repositories.UserProfileRepository;
import com.detrasoft.historapp.auth.domain.services.crud.user.UserProfileCRUDService;
import com.detrasoft.framework.api.controllers.GenericDetailController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "users/{idDetail}/profiles")
public class UserProfileController extends GenericDetailController<UserProfileDTO> {

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Autowired
    public UserProfileController(UserProfileCRUDService service, UserProfileConverter converter) {
        super(service, converter);
    }

    @Override
    protected void setIdSubDetailInDTO(Long idDetail, Long idSubDetail, UserProfileDTO dto) {
        dto.setIdUser(idDetail);
    }

    @Override
    protected Page<?> findAllByIdDetail(Long idDetail, Pageable pageable) {
        return userProfileRepository.findByUserId(idDetail, pageable);
    }
}
