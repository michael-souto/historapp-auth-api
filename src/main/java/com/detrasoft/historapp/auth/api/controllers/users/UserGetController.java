package com.detrasoft.historapp.auth.api.controllers.users;

import com.detrasoft.historapp.auth.api.converters.UserConverter;
import com.detrasoft.historapp.auth.api.dto.user.UserDTO;
import com.detrasoft.historapp.auth.domain.filters.UserFilter;
import com.detrasoft.historapp.auth.domain.repositories.UserRepository;
import com.detrasoft.historapp.auth.domain.services.crud.user.UserCRUDService;
import com.detrasoft.historapp.auth.domain.specifications.UserSpecs;
import com.detrasoft.framework.api.controllers.crud.GenericGetController;
import com.detrasoft.framework.crud.entities.GenericEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserGetController extends GenericGetController<UserDTO> {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public UserGetController(UserCRUDService service, UserConverter converter) {
        super(service, converter);
    }

    @Override
    protected GenericEntity getOne(String id) {
        return ((UserCRUDService)service).finUserdByCode(id);
    }

    @GetMapping(value = "/search")
    public ResponseEntity<Page<UserDTO>> search(UserFilter filter, Pageable pageable) {
        var list = userRepository.findAll(UserSpecs.withUserFilter(filter), pageable);

        Page<UserDTO> resultList = new PageImpl<UserDTO>(
                list.getContent().stream()
                        .map(obj -> converter.toDto(obj)).toList(), pageable, list.getTotalElements());
        return ResponseEntity.ok().body(resultList);
    }

}
