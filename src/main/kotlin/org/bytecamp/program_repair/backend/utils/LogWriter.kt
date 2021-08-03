package org.bytecamp.program_repair.backend.utils

import org.apache.logging.log4j.Logger

class LogWriter (val log: Logger): IWriter {
    override fun write(chunk: String) {
        log.debug(chunk)
    }

}