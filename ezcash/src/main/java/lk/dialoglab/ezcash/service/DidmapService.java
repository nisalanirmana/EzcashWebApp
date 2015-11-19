package lk.dialoglab.ezcash.service;

import java.util.List;

import lk.dialoglab.ezcash.domain.Didmap;
import lk.dialoglab.ezcash.domain.WebUser;
import lk.dialoglab.ezcash.dto.DidmapDto;

public interface DidmapService {

    public void addDidmap(DidmapDto didmapdto);

    public List<Didmap> getDidmap();
}
