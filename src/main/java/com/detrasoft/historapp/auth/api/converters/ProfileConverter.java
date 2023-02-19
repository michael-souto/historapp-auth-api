package com.detrasoft.historapp.auth.api.converters;

import com.detrasoft.historapp.auth.api.dto.ProfileDTO;
import com.detrasoft.historapp.auth.domain.entities.Profile;
import com.detrasoft.framework.api.dto.converters.GenericEntityDTOConverter;
import org.springframework.stereotype.Component;

@Component
public class ProfileConverter  extends GenericEntityDTOConverter<Profile, ProfileDTO> {
}
