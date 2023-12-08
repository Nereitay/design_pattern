package es.kiwi.structural.facade.example3;

import lombok.Getter;
import lombok.Setter;

/**
 * 示意配置描述的数据Model，真实的配置数据会很多
 */
@Getter
@Setter
public class ConfigModel {
    /**
     * 是否需要生成表现层，默认是true
     */
    private boolean needGenPresentation = true;
    /**
     * 是否需要生成逻辑层，默认是true
     */
    private boolean needGenBusiness = true;
    /**
     * 是否需要生成DAO，默认是true
     */
    private boolean needGenDAO = true;
}
