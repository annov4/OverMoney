package com.override.orchestrator_service.feign;

import com.override.dto.tinkoff.TinkoffAccountDTO;
import com.override.dto.tinkoff.TinkoffActiveDTO;
import com.override.dto.tinkoff.TinkoffActiveMOEXDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "invest", url = "http://sa-invest-svc")
public interface InvestFeign {

    @GetMapping("/tinkoff/actives")
    List<TinkoffActiveDTO> getActives(@RequestParam("token") String token,
                                      @RequestParam("tinkoffAccountId") String tinkoffAccountId);

    @GetMapping("/tinkoff/moex")
    List<TinkoffActiveMOEXDTO> getActivesMoexPercentage(@RequestParam("token") String token,
                                                        @RequestParam("tinkoffAccountId") String tinkoffAccountId);

    @GetMapping("/tinkoff/accounts")
    List<TinkoffAccountDTO> getUserAccounts(@RequestParam("token") String token);
}
