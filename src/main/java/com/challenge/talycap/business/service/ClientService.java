package com.challenge.talycap.business.service;

import com.challenge.talycap.business.dto.ClientDto;

public interface ClientService {

   ClientDto getByIdentAndTypeDoc(final String ident, final String typeDoc);

}
